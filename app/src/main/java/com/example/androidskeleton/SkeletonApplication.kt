package com.example.androidskeleton

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class SkeletonApplication :Application() {
    init {
        instance = this
    }
    companion object {
        private var instance: SkeletonApplication? = null
        fun getApplicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}