package com.example.androidskeleton.utils

import kotlinx.coroutines.Dispatchers

class CoroutineDispatcherProvider {
    fun IO() = Dispatchers.IO

    fun Default() = Dispatchers.Default

    fun Main() = Dispatchers.Main
}