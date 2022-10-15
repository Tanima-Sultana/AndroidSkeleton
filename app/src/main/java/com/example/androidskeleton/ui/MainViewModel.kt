package com.example.androidskeleton.ui

import androidx.lifecycle.viewModelScope
import com.example.androidskeleton.domain.base.BaseFragmentViewModel
import com.example.androidskeleton.domain.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val userDataRepository: UserDataRepository): BaseFragmentViewModel() {

    fun authenticateUser(userIdP: String, passwordP: String) {
        val userId = userIdP.trim { it <= ' ' }
        val password = passwordP.trim { it <= ' ' }

//        if (!isValidCredential(userId, password)) {
//            isLoadingDataLiveData.postValue(false)
//            return
//        }

        viewModelScope.launch(Dispatchers.IO) {
            try {
//                val response = loginRepository.login(userId, password)
//                isLoadingDataLiveData.postValue(false)
//
//                val userResponse = response.body()?.user
//                if (response.code() == 200 && userResponse != null){
//                    loginRepository.insertLoginData(userId, password)
//                    val user = userRepository.insertUser(userResponse)
//                    userRepository.userLoggedIn(user)
//                    getLogInData()
//                } else if(response.code() == 404) {
//                    isLogInDataLiveData.postValue("Use right server url to login or reset your url")
//                    userLive.postValue(null)
//                    isLoadingDataLiveData.postValue(false)
//                }else{
//                    isLogInDataLiveData.postValue(response.errorBody()?.string())
//                    userLive.postValue(null)
//                    isLoadingDataLiveData.postValue(false)
//                }
            } catch (e: Exception) {
//                isLogInDataLiveData.postValue(e.localizedMessage)
//                isLoadingDataLiveData.postValue(false)
            }
        }
    }
}