package com.example.androidskeleton.data.schedule.source.network

import com.example.androidskeleton.data.schedule.api.UserDataAPIService
import com.example.androidskeleton.data.schedule.model.UserInfo
import com.example.androidskeleton.data.schedule.source.ScheduleUserData
import javax.inject.Inject

class NetworkUserEntityData @Inject constructor(private val userDataAPIService: UserDataAPIService) :
    ScheduleUserData {
    override suspend fun getUserData(): List<UserInfo> {
        return userDataAPIService.getPraySchedule()
    }

    override suspend fun addUserData(userData: List<UserInfo>) {
        //TODO("Not yet implemented")
    }

}