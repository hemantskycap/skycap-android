@file:JvmName("Booleans")

package skycap.android.core.extensions

/**
 * Convert boolean value to integer
 * */
fun Boolean.intValue(): Int = if (this) 1 else 0

/**
 * Convert integer value to boolean
 * */
fun Int.boolValue(): Boolean = this > 0
