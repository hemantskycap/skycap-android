package skycap.android.core.encrypt

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


class EncryptionHelper(secret: String, iv: String) {

    private val secretKey = SecretKeySpec(secret.toByteArray(Charsets.UTF_8), "AES")
    private val cipher = Cipher.getInstance("AES/CBC/NoPadding")
    private val ivParameterSpec = IvParameterSpec(iv.toByteArray(Charsets.UTF_8))


    fun encrypt(string: String): String? {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec)

            // convert to bytes
            var bytes: ByteArray = string.toByteArray(Charsets.UTF_8)

            // encrypt bytes
            bytes = cipher.doFinal(bytes)

            // encode bytes
            bytes = Base64.encode(bytes, Base64.NO_PADDING)

            return String(bytes, Charsets.UTF_8)

        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            return null
        }
    }


    fun decrypt(string: String): String? {
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec)

            // convert to bytes
            var bytes: ByteArray = string.toByteArray(Charsets.UTF_8)

            // decode Base64 bytes
            bytes = Base64.decode(bytes, Base64.NO_PADDING)

            // decrypt Base64 bytes
            bytes = cipher.doFinal(bytes)

            return String(bytes, Charsets.UTF_8)

        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            return string
        }
    }
}