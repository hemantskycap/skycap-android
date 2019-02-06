@file:Suppress("unused")

package skycap.android.core.widget

import android.content.Context
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.ViewGroup

class CenterTabLayout : TabLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        val firstTab = (getChildAt(0) as ViewGroup).getChildAt(0)
        val lastTab = (getChildAt(0) as ViewGroup).getChildAt((getChildAt(0) as ViewGroup).childCount - 1)
        ViewCompat.setPaddingRelative(
            getChildAt(0),
            width / 2 - firstTab.width / 2,
            0,
            width / 2 - lastTab.width / 2,
            0
        )
    }
}