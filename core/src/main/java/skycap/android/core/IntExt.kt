@file:JvmName("IntExt")
@file:Suppress("unused")

package skycap.android.core


/**
 * Convert integer value to boolean
 * */
fun Int.boolValue(): Boolean = this > 0
