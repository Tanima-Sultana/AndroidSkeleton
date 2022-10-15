package com.example.androidskeleton.domain.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidskeleton.data.schedule.model.ui.ProgressBarData
import com.example.androidskeleton.data.schedule.model.ui.SimpleAlertData
import com.example.androidskeleton.data.schedule.model.ui.SkeletonState
import com.example.androidskeleton.utils.Event

open class BaseFragmentViewModel:ViewModel() {
    val loading: MutableLiveData<Event<ProgressBarData>> by lazy {
        MutableLiveData<Event<ProgressBarData>>()
    }

    val message: MutableLiveData<Event<SimpleAlertData>> by lazy {
        MutableLiveData<Event<SimpleAlertData>>()
    }

    val toastMessage: MutableLiveData<Event<String>> by lazy {
        MutableLiveData<Event<String>>()
    }

    val uiState: MutableLiveData<SkeletonState> by lazy {
        MutableLiveData<SkeletonState>()
    }

    fun setUIState(uiStateValue: SkeletonState) {
        uiState.postValue(uiStateValue)
    }

    protected fun showLoader(loadingMessage:String = "") {
        loading.postValue(Event(ProgressBarData(true, loadingMessage)))
    }

    protected fun hideLoader() {
        loading.postValue(Event(ProgressBarData()))
    }

    protected fun showAlertMessage(alertTitle: String = "", alertMessage: String) {
        if (alertTitle.isBlank()) {
            message.postValue(Event(SimpleAlertData(message = alertMessage)))
            return
        }
        message.postValue(Event(SimpleAlertData(titlle = alertTitle, message = alertMessage)))
    }

    protected fun showToastMessage(string: String) {
        toastMessage.postValue(Event(string))
    }
}