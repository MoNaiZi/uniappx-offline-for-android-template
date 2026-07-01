@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.xQrcode
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
open class QrCodeArg (
    @JsonNotNull
    open var content: String,
    open var width: Number? = null,
    open var height: Number? = null,
    open var colorBlack: String? = null,
    open var colorWhite: String? = null,
) : UTSObject()
typealias QrCode = (t: QrCodeArg) -> String?
fun hexColorToNumber(reassignedHex: String): Int {
    var hex = reassignedHex
    if (hex.length === 4) {
        hex = hex.replace(UTSRegExp("^#(.)(.)(.)\$", ""), "#\$1\$1\$2\$2\$3\$3")
    }
    hex = hex.replace(UTSRegExp("^#", ""), "")
    hex = "FF" + hex
    return parseInt(hex, 16).toInt()
}
val qrCode: QrCode = fun(config: QrCodeArg): String {
    var content = config.content
    var width = config.width
    var height = config.height
    var colorBlack = config.colorBlack
    var colorWhite = config.colorWhite
    console.log("colorBlack", colorBlack, if (colorBlack != null) {
        hexColorToNumber(colorBlack)
    } else {
        "null"
    }
    , "##", if (colorWhite != null) {
        hexColorToNumber(colorWhite)
    } else {
        "white-null"
    }
    , 0xFF000000.toInt())
    val res: String = NativeCode.bitmapToBase64(content, if (width != null) {
        width.toInt()
    } else {
        700
    }
    , if (height != null) {
        height.toInt()
    } else {
        700
    }
    , if (colorBlack != null) {
        hexColorToNumber(colorBlack)
    } else {
        0xFF000000.toInt()
    }
    , if (colorWhite != null) {
        hexColorToNumber(colorWhite)
    } else {
        0xFFFFFFFF.toInt()
    }
    )
    return res
}
