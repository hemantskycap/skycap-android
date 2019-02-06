@file:Suppress("unused")

package skycap.android.core.resource


sealed class Resource<out T> {

    class Loading<T> : Resource<T>()

    data class Success<T>(val value: T) : Resource<T>()

    data class Error<T>(val code: Int) : Resource<T>()

    val isLoading: Boolean get() = this is Resource.Loading

    val isSuccess: Boolean get() = this is Resource.Success

    val isError: Boolean get() = this is Resource.Error

}