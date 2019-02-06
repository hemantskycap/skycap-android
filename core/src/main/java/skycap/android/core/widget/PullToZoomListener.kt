@file:Suppress("unused")

package skycap.android.core.widget

import android.animation.Animator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.view.GestureDetectorCompat
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import skycap.android.core.LOG_TAG

class PullToZoomListener(
    context: Context,
    maxZoomDp: Int,
    private val mOnZoomChangeListener: OnZoomChangeListener
) : View.OnTouchListener {

    private val maxZoomDp: Float = maxZoomDp.toFloat() / 100
    private val myGestureListener = MyGestureListener()
    private val mDetector = GestureDetectorCompat(context, myGestureListener)

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        if (motionEvent.action == MotionEvent.ACTION_UP) {
            myGestureListener.upDetected()
        }
        return mDetector.onTouchEvent(motionEvent)
    }

    private inner class MyGestureListener : GestureDetector.SimpleOnGestureListener() {
        private var delta: Float = 0f
        private var valueAnimator: ValueAnimator? = null
        private var mFirstEvent = true

        override fun onDown(event: MotionEvent): Boolean = true

        override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
            valueAnimator?.cancel()

            if (mFirstEvent) {
                mFirstEvent = false
                mOnZoomChangeListener.onZoomStart()
                return false
            }

            delta += distanceY
            val pct = getPct(delta)
            val pctInto100 = (pct * 100).toInt()
            Log.d(LOG_TAG, "pctInto100 = $pctInto100")

            mOnZoomChangeListener.onZoom(pctInto100)

            return false
        }

        fun upDetected() {
            mFirstEvent = true
            val pct = getPct(delta)

            valueAnimator = ValueAnimator().apply {
                setFloatValues(pct, 0.0f)

                addUpdateListener { animation ->
                    (animation.animatedValue as? Float)?.also {
                        Log.d(LOG_TAG, "animation.getAnimatedValue() = $animatedValue")

                        val pctInto100 = (it * 100).toInt()
                        Log.d(LOG_TAG, "pctInto100 = $pctInto100")

                        mOnZoomChangeListener.onZoom(pctInto100)
                    }
                }

                addListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) {
                        mOnZoomChangeListener.onZoomStart()
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        delta = 0f
                        mOnZoomChangeListener.onZoomEnd()
                    }

                    override fun onAnimationCancel(animation: Animator) {}
                    override fun onAnimationRepeat(animation: Animator) {}
                })
            }

            valueAnimator?.start()

        }

        private fun getPct(delta: Float): Float {
            var pct = -delta / PCT
            if (pct >= maxZoomDp) {
                pct = maxZoomDp
            } else if (pct <= 0) {
                pct = 0f
            }
            return pct
        }
    }

    interface OnZoomChangeListener {
        fun onZoomStart()
        fun onZoomEnd()
        fun onZoom(level: Int)
    }

    companion object {
        private const val PCT = 300f
    }

}