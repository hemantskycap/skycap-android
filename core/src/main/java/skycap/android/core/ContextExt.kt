@file:JvmName("ContextExt")
@file:Suppress("unused")

package skycap.android.core

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings

fun Context.showAppSettings() {
    val intent = Intent()
    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
    val uri = Uri.fromParts("package", packageName, null)
    intent.data = uri
    startActivity(intent)
}