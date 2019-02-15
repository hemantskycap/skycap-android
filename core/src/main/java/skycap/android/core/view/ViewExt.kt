@file:JvmName("ViewExt")
@file:Suppress("unused")

package skycap.android.core.view

import android.view.View


fun View.setVisibleOrGone(visibility: Boolean?) {
    val visible = if (visibility == true) View.VISIBLE else View.GONE
    this.visibility = visible
}


fun View.setVisibleOrInvisible(visibility: Boolean?) {
    val visible = if (visibility == true) View.VISIBLE else View.INVISIBLE
    this.visibility = visible
}
