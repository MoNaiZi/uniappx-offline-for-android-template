@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.ysapi
import android.app.Application
import android.util.Log
import com.ys.rkapi.MyManager
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
import java.net.Inet4Address
import java.net.NetworkInterface
import java.net.SocketException
import java.util.Collections
import kotlin.properties.Delegates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
var instance: SystemHelper? = null
open class SystemHelper {
    private var mMyManager: MyManager? = null
    private var mApp: Application? = null
    private constructor(){}
    public open fun init(app: Application) {
        this.mApp = app
        this.mMyManager = MyManager.getInstance(app)
        this.mMyManager?.bindAIDLService(app)
    }
    public open fun getSn(): String {
        if (this.mMyManager != null) {
            val sn = this.mMyManager!!.getSn()
            Log.d("Vimin", "sn:" + sn)
            return sn
        }
        return ""
    }
    public open fun getIp(): String {
        var ethernetIp = ""
        try {
            val niList = Collections.list(NetworkInterface.getNetworkInterfaces())
            run {
                var i: Int = 0
                while(i < niList.size){
                    val ni = niList[i]
                    val iaList = Collections.list(ni.getInetAddresses())
                    run {
                        var j: Int = 0
                        while(j < iaList.size){
                            val address = iaList[j]
                            if (!address.isLoopbackAddress() && address is Inet4Address) {
                                return address.getHostAddress()
                            }
                            j++
                        }
                    }
                    i++
                }
            }
        }
         catch (e: SocketException) {}
        return ethernetIp
    }
    public open fun reboot() {
        this.mMyManager?.reboot()
    }
    public open fun shutdown() {
        this.mMyManager?.shutdown()
    }
    public open fun hideNavBar() {
        if (this.mMyManager != null) {
            this.mMyManager!!.hideNavBar(true)
            this.mMyManager!!.hideStatusBar(false)
            this.mMyManager!!.setSlideShowNavBar(false)
            this.mMyManager!!.setSlideShowNotificationBar(false)
        }
    }
    public open fun showNavBar() {
        if (this.mMyManager != null) {
            this.mMyManager!!.hideNavBar(false)
            this.mMyManager!!.hideStatusBar(true)
            this.mMyManager!!.setSlideShowNavBar(true)
            this.mMyManager!!.setSlideShowNotificationBar(true)
        }
    }
    companion object {
        public fun getInstance(): SystemHelper {
            if (instance == null) {
                instance = SystemHelper()
            }
            return instance!!
        }
    }
}
fun getSystemHelper(): SystemHelper {
    return SystemHelper.getInstance()
}
