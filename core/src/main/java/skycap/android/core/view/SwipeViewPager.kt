@file:Suppress("unused")

package skycap.android.core.view

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent
import skycap.android.core.R


class SwipeViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    var swipeEnabled: Boolean = false

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.SwipeViewPager)
        try {
            swipeEnabled = a.getBoolean(R.styleable.SwipeViewPager_enableSwipe, true)
        } finally {
            a.recycle()
        }
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean = swipeEnabled && super.onInterceptTouchEvent(event)

    override fun onTouchEvent(event: MotionEvent): Boolean = swipeEnabled && super.onTouchEvent(event)
}
