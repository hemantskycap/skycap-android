@file:JvmName("BooleanExtensions")

package skycap.android.core

/**
 * Convert boolean value to integer
 * */
fun Boolean.intValue(): Int = if (this) 1 else 0
