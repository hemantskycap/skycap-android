@file:Suppress("unused")

package skycap.android.core.helper

object UrlHelper {

    fun getYouTubeVideoThumbnailUrl(videoId: String): String {
        return "http://img.youtube.com/vi/$videoId/0.jpg"
    }
}