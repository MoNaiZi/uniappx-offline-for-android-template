@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.scan
import com.ztec.bsp.zbcr.ZBarcodeReader
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
open class ScanResult (
    @JsonNotNull
    open var isSuccess: Boolean = false,
    @JsonNotNull
    open var message: String,
    @JsonNotNull
    open var data: String,
) : UTSObject()
var scanThread: Thread? = null
var zbReader: ZBarcodeReader? = null
var scanCallback: ((result: ScanResult) -> Unit)? = null
fun startScan(callback: (result: ScanResult) -> Unit): Unit {
    if (scanThread != null && scanThread!!.isAlive()) {
        callback(ScanResult(isSuccess = false, message = "扫码枪正在使用中", data = ""))
        return
    }
    scanCallback = callback
    scanThread = Thread(Runnable(fun(){
        zbReader = ZBarcodeReader()
        val ret: Number = zbReader!!.ZBCR_Open("/dev/ttyACM0", 9600)
        if (ret > 0) {
            zbReader!!.ZBCR_Led(1)
            var flag: Boolean = true
            var result: String = ""
            while(flag){
                try {
                    Thread.sleep(500)
                } catch (e: Throwable) {
                    if (scanCallback != null) {
                        scanCallback!!(ScanResult(isSuccess = false, message = "扫码已取消", data = ""))
                    }
                    closeReader()
                    return
                }
                val bytes: ByteArray? = zbReader!!.ZBCR_ReadDecode(1)
                if (bytes != null && bytes.size > 0) {
                    flag = false
                    result = String(bytes)
                }
            }
            if (result.length > 0 && scanCallback != null) {
                scanCallback!!(ScanResult(isSuccess = true, message = "SUCCESS", data = result))
            }
            closeReader()
        } else {
            if (scanCallback != null) {
                scanCallback!!(ScanResult(isSuccess = false, message = "扫码枪打开失败", data = ""))
            }
            zbReader = null
        }
    }
    ))
    scanThread!!.start()
}
fun stopScan(): Unit {
    if (scanThread != null) {
        scanThread!!.interrupt()
        scanThread = null
    }
    closeReader()
    scanCallback = null
}
fun closeReader(): Unit {
    if (zbReader != null) {
        zbReader!!.ZBCR_Close()
        zbReader = null
    }
}
