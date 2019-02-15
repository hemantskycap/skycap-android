@file:Suppress("unused")

package skycap.android.core.sharedprefs

import android.content.SharedPreferences

class SharedPrefsHelper constructor(private val prefs: SharedPreferences) {

    fun save(key: String, value: Int) {
        prefs.edit().putInt(key, value).apply()
    }

    fun save(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    fun save(key: String, value: Long) {
        prefs.edit().putLong(key, value).apply()
    }

    fun save(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }

    fun saveStringSet(key: String, value: Set<String>) {
        prefs.edit().putStringSet(key, value).apply()
    }

    fun get(key: String, defaultValue: Int): Int {
        return prefs.getInt(key, defaultValue)
    }

    fun getInt(key: String, defaultValue: Int): Int? {
        return if (prefs.contains(key)) prefs.getInt(key, defaultValue)
        else null
    }

    fun get(key: String, defaultValue: String): String {
        return prefs.getString(key, defaultValue) ?: defaultValue
    }

    fun getString(key: String): String? {
        return prefs.getString(key, null)
    }

    fun get(key: String, defaultValue: Long): Long {
        return prefs.getLong(key, defaultValue)
    }

    fun getLong(key: String): Long? {
        return if (prefs.contains(key)) {
            prefs.getLong(key, 0L)
        } else {
            null
        }
    }

    fun get(key: String, defaultValue: Boolean): Boolean {
        return prefs.getBoolean(key, defaultValue)
    }

    fun getBoolean(key: String): Boolean? {
        return if (prefs.contains(key)) {
            prefs.getBoolean(key, false)
        } else {
            null
        }
    }

    fun getStringSet(key: String): Set<String>? {
        return prefs.getStringSet(key, null)
    }

    fun delete(key: String) {
        prefs.edit().remove(key).apply()
    }

    fun deleteAll() {
        prefs.edit().clear().apply()
    }

    fun containsKey(key: String): Boolean {
        return prefs.contains(key)
    }
}
