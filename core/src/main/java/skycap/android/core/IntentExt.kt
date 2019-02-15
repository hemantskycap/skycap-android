@file:JvmName("IntentExt")
@file:Suppress("unused")

package skycap.android.core

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings


fun Context.intentToShowAppSettings() {
    val intent = Intent()
    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
    val uri = Uri.fromParts("package", packageName, null)
    intent.data = uri
    startActivity(intent)
}

fun Context.intentToWatchYoutubeVideo(videoId: String): Boolean {
    val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$videoId"))
    val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$videoId"))

    return try {
        startActivity(appIntent)
        true
    } catch (e: Exception) {
        e.printStackTrace()
        try {
            startActivity(webIntent)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}

fun Context.intentToOpenUrl(url: String): Boolean {
    return try {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}

fun Context.intentToShareTextOnWhatsApp(message: String): Boolean {
    return try {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, message)
        sendIntent.type = "text/plain"
        sendIntent.`package` = "com.whatsapp"
        startActivity(sendIntent)
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}

fun Context.intentToShareText(text: String): Boolean {
    return try {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, text)
        sendIntent.type = "text/plain"
        startActivity(sendIntent)
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}

