package skycap.android.core

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

fun <T : Any, L : LiveData<T>> observeForever(liveData: L, body: (T?) -> Unit): Observer<T> {
    val observer = Observer<T>(body)
    liveData.observeForever(observer)
    return observer
}

fun <T : Any, L : LiveData<T>> observeForeverNonNull(liveData: L, body: (T) -> Unit): Observer<T> {
    val observer = Observer<T> { it?.apply(body) }
    liveData.observeForever(observer)
    return observer
}

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit): Observer<T> {
    val observer = Observer<T>(body)
    liveData.observe(this, observer)
    return observer
}

fun <T : Any, L : LiveData<T>> LifecycleOwner.observeNonNull(liveData: L, body: (T) -> Unit): Observer<T> {
    val observer = Observer<T> { it?.apply(body) }
    liveData.observe(this, observer)
    return observer
}

/**
 * Observe [LiveData] in blocking mode,
 * Can be used in testing
 * */
fun <T> LiveData<T>.observeBlocking(count: Int = 1, waitInSeconds: Long = 2): T? {
    var value: T? = null
    val latch = CountDownLatch(count)

    val observer = Observer<T> { t ->
        value = t
        latch.countDown()
    }

    observeForever(observer)

    latch.await(waitInSeconds, TimeUnit.SECONDS)
    return value
}

fun <T> LiveData<T>.distinct(): LiveData<T> {
    val distinctLiveData = MediatorLiveData<T>()

    distinctLiveData.addSource(this, object : Observer<T> {
        private var lastObj: T? = null

        override fun onChanged(obj: T?) {
            if (obj != lastObj) {
                lastObj = obj
                distinctLiveData.postValue(lastObj)
            }
        }
    })

    return distinctLiveData
}
