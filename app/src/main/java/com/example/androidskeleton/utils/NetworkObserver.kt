package com.example.androidskeleton.utils

import android.util.Log
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

abstract class NetworkObserver<T> :SingleObserver<T>  {
    private var disposable: Disposable? = null

    override fun onSubscribe(d: Disposable) {
        disposable = d
    }

    override fun onSuccess(response: T) {
        onSuccessful(response)
        disposable?.dispose()
    }

    override fun onError(throwable: Throwable) {
        Log.e("NetworkObserver", throwable.toString())
        onError(throwable.message.orEmpty())
    }

    abstract fun onSuccessful(response: T)

    abstract fun onError(message: String)
}