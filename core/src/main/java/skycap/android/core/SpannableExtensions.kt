package skycap.android.core

import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.*

/**
 * this way it possible to nest spans
 * spannable {
 * italic(underline(bold(size(2f, color(Color.RED, "Red Bold Color")))))
 * }
 * */
fun spannable(func: () -> SpannableString) = func()

private fun span(s: CharSequence, o: Any): SpannableString {
    val spannableString = if (s is String) {
        SpannableString(s)
    } else {
        s as? SpannableString ?: SpannableString("")
    }
    spannableString.setSpan(o, 0, spannableString.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    return spannableString
}

operator fun SpannableString.plus(s: SpannableString) = SpannableString(TextUtils.concat(this, s))
operator fun SpannableString.plus(s: String) = SpannableString(TextUtils.concat(this, s))

fun bold(s: CharSequence) = span(s, StyleSpan(android.graphics.Typeface.BOLD))
fun bold(s: SpannableString) = span(s, StyleSpan(android.graphics.Typeface.BOLD))

fun italic(s: CharSequence) = span(s, StyleSpan(android.graphics.Typeface.ITALIC))
fun italic(s: SpannableString) = span(s, StyleSpan(android.graphics.Typeface.ITALIC))

fun underline(s: CharSequence) = span(s, UnderlineSpan())
fun underline(s: SpannableString) = span(s, UnderlineSpan())

fun strike(s: CharSequence) = span(s, StrikethroughSpan())
fun strike(s: SpannableString) = span(s, StrikethroughSpan())

fun sup(s: CharSequence) = span(s, SuperscriptSpan())
fun sup(s: SpannableString) = span(s, SuperscriptSpan())

fun sub(s: CharSequence) = span(s, SubscriptSpan())
fun sub(s: SpannableString) = span(s, SubscriptSpan())

fun size(size: Float, s: CharSequence) = span(s, RelativeSizeSpan(size))
fun size(size: Float, s: SpannableString) = span(s, RelativeSizeSpan(size))

fun color(color: Int, s: CharSequence) = span(s, ForegroundColorSpan(color))
fun color(color: Int, s: SpannableString) = span(s, ForegroundColorSpan(color))

fun background(color: Int, s: CharSequence) = span(s, BackgroundColorSpan(color))
fun background(color: Int, s: SpannableString) = span(s, BackgroundColorSpan(color))

fun url(url: String, s: CharSequence) = span(s, URLSpan(url))
fun url(url: String, s: SpannableString) = span(s, URLSpan(url))

fun normal(s: CharSequence) = span(s, SpannableString(s))
fun normal(s: SpannableString) = span(s, SpannableString(s))
