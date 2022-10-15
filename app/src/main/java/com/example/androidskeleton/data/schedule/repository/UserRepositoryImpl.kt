package com.example.androidskeleton.data.schedule.repository

import com.example.androidskeleton.data.schedule.factory.UserDataFactory
import com.example.androidskeleton.data.schedule.model.UserInfo
import com.example.androidskeleton.domain.repository.UserDataRepository
import com.example.androidskeleton.utils.enum.Source
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userdataFactory: UserDataFactory): UserDataRepository {
    override suspend fun getUserDataFromNetwork(): List<UserInfo> {
       return userdataFactory.create(Source.NETWORK).getUserData()
    }

    override suspend fun getUserDataFromLocal(): List<UserInfo> {
        return userdataFactory.create(Source.LOCAL).getUserData()
    }

    override suspend fun addUserData(praySchedules: List<UserInfo>) {

    }

}