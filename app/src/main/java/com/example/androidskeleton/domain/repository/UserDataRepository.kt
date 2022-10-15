package com.example.androidskeleton.domain.repository

import com.example.androidskeleton.data.schedule.model.UserInfo

interface UserDataRepository {

    //TODO request body or parameter can b added in the get methods
    suspend fun getUserDataFromNetwork(): List<UserInfo>

    suspend fun getUserDataFromLocal(): List<UserInfo>

    suspend fun addUserData(userInfo: List<UserInfo>)
}