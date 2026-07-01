import android.graphics.Bitmap
import android.util.Base64.encodeToString
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter
import java.io.ByteArrayOutputStream
import android.util.Base64
import java.util.*

object NativeCode {
    fun generateQRCode(
      content: String,
       width: Int = 200,
       height: Int = 200,
       colorBlack: Int,
       colorWhite: Int
    ): Bitmap? {
        val hints = Hashtable<EncodeHintType, Any>().apply {
            put(EncodeHintType.CHARACTER_SET, "UTF-8")
            put(EncodeHintType.MARGIN, 1)
        }

        return try {
            val bitMatrix = QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints)
            val pixels = IntArray(width * height)
            for (y in 0 until height) {
                for (x in 0 until width) {
                    pixels[y * width + x] = if (bitMatrix[x, y]) colorBlack else colorWhite
                }
            }
            Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888).apply {
                setPixels(pixels, 0, width, 0, 0, width, height)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    fun bitmapToBase64(
        content: String,
        width: Int = 200,
        height: Int = 200,
        colorBlack: Int = 0xFF000000.toInt(),
        colorWhite: Int = 0xFFFFFFFF.toInt()
    ): String {
        val bitmap: Bitmap = generateQRCode(content, width, height, colorBlack, colorWhite)
            ?: return "null"
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        return "data:image/png;base64," +Base64.encodeToString(byteArray, Base64.DEFAULT)
    }
}