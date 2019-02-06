@file:JvmName("BooleanExt")
@file:Suppress("unused")

package skycap.android.core

/**
 * Convert boolean value to integer
 * */
fun Boolean.intValue(): Int = if (this) 1 else 0
