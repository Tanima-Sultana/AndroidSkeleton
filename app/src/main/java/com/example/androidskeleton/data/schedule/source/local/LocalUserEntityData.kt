package com.example.androidskeleton.data.schedule.source.local

import com.example.androidskeleton.data.schedule.model.UserInfo
import com.example.androidskeleton.data.schedule.room.dao.UserInfoDao
import com.example.androidskeleton.data.schedule.source.ScheduleUserData
import javax.inject.Inject

class LocalUserEntityData @Inject constructor(private val userInfoDao: UserInfoDao) :
    ScheduleUserData {
    override suspend fun getUserData(): List<UserInfo> {
        return userInfoDao.getPraySchedule()
    }

    override suspend fun addUserData(praySchedules: List<UserInfo>) {
       // TODO("Not yet implemented")
    }
}