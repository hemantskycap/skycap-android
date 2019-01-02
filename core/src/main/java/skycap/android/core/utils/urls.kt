package skycap.android.core.utils

object Urls {

    fun getYouTubeVideoThumbnailUrl(videoId: String): String {
        return "http://img.youtube.com/vi/$videoId/0.jpg"
    }
}