package com.example.androidskeleton.data.schedule.source

import com.example.androidskeleton.data.schedule.model.UserInfo

interface ScheduleUserData {
    suspend fun getUserData(): List<UserInfo>

    suspend fun addUserData(userData: List<UserInfo>)

}