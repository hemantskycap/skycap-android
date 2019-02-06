@file:JvmName("AnyExt")
@file:Suppress("unused")

package skycap.android.core


val Any.LOG_TAG: String get() = this.javaClass.simpleName