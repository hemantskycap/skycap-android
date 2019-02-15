@file:Suppress("unused")

package skycap.android.core.device

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings


class DeviceIdHelper(context: Context) {

    @SuppressLint("HardwareIds")
    private val uuid: String = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)

    fun getDeviceId(): String {
        return uuid
    }

}