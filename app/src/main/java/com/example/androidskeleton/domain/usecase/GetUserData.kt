package com.example.androidskeleton.domain.usecase

import com.example.androidskeleton.data.schedule.model.UserInfo
import com.example.androidskeleton.domain.repository.UserDataRepository
import javax.inject.Inject

class GetUserData @Inject constructor(private val userDataRepository: UserDataRepository) {
    suspend fun execute(request: UserInfo): List<UserInfo> {
        return getUserDataFromLocal(request).ifEmpty {
            val userData = getUserDataFromNetwork(request)

            userDataRepository.addUserData(userData)
            getUserDataFromLocal(request)
        }
    }

    private suspend fun getUserDataFromLocal(param: UserInfo): List<UserInfo> {
        return userDataRepository.getUserDataFromLocal()
    }

    private suspend fun getUserDataFromNetwork(param: UserInfo): List<UserInfo> {
        return userDataRepository.getUserDataFromNetwork()
    }
}