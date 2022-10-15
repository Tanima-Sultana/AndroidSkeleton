package com.example.androidskeleton.data.schedule.model.ui

sealed class SkeletonState{
    object Success: SkeletonState()
    data class ErrorAlert(val errorTitle: String = "", val errorMessage: String): SkeletonState()
    data class ErrorToast(val errorMessage: String): SkeletonState()
    data class Loading(val loadingMessage: String = ""): SkeletonState()
    object Empty: SkeletonState()
}
