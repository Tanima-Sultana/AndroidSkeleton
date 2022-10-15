package com.example.androidskeleton.ui.home

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidskeleton.data.schedule.model.UserInfo
import com.example.androidskeleton.domain.usecase.GetUserData
import com.example.androidskeleton.utils.CoroutineDispatcherProvider
import com.example.androidskeleton.utils.ExceptionParser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserData: GetUserData,
    //private val coroutineDispatcherProvider: CoroutineDispatcherProvider

): ViewModel(){

    private val _uiState = MutableStateFlow<PrayUiState>(PrayUiState.Empty)
    val uiState: StateFlow<PrayUiState> = _uiState

    fun getPraySchedule() {
        _uiState.value = PrayUiState.Loading

        viewModelScope.launch {
            try {
                val city = "Jakarta"
                val requestParam = UserInfo("","","","","",0)
                val result = getUserData.execute(requestParam)

                _uiState.value = PrayUiState.Loaded(UserInfo("","","","","",0))
            } catch (error: Exception) {
                _uiState.value = PrayUiState.Error(ExceptionParser.getMessage(error))
            }
        }
//        viewModelScope.launch(coroutineDispatcherProvider.IO()) {
//            try {
//                val city = "Jakarta"
//                val requestParam = UserInfo("","","","","",0)
//                val result = getUserData.execute(requestParam)
//
//                _uiState.value = PrayUiState.Loaded(UserInfo("","","","","",0))
//            } catch (error: Exception) {
//                _uiState.value = PrayUiState.Error(ExceptionParser.getMessage(error))
//            }
//        }
    }
}


sealed class PrayUiState {
    object Empty : PrayUiState()
    object Loading : PrayUiState()
    class Loaded(val itemState: UserInfo) : PrayUiState()
    class Error(@StringRes val message: Int) : PrayUiState()
}