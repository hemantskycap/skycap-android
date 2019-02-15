@file:JvmName("DisplayExt")
@file:Suppress("unused")

package skycap.android.core.device

import android.content.Context
import android.util.DisplayMetrics


fun Context.getScreenHeightInPixels(): Float {
    return resources.displayMetrics.heightPixels.toFloat()
}

fun Context.getScreenWidthInPixels(): Float {
    return resources.displayMetrics.widthPixels.toFloat()
}

fun Context.getScreenHeightInDp(): Float {
    val displayMetrics = resources.displayMetrics
    return displayMetrics.heightPixels / displayMetrics.density
}

fun Context.getScreenWidthInDp(): Float {
    val displayMetrics = resources.displayMetrics
    return displayMetrics.widthPixels / displayMetrics.density
}

fun Context.getPixels(dp: Float): Float {
    val metrics = resources.displayMetrics
    return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}

fun Context.getDp(px: Float): Float {
    val metrics = resources.displayMetrics
    return px / (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}
