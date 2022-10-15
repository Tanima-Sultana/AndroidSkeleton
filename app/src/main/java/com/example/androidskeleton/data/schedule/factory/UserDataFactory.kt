package com.example.androidskeleton.data.schedule.factory

import com.example.androidskeleton.data.schedule.source.ScheduleUserData
import com.example.androidskeleton.data.schedule.source.local.LocalUserEntityData
import com.example.androidskeleton.data.schedule.source.network.NetworkUserEntityData
import com.example.androidskeleton.utils.enum.Source
import javax.inject.Inject

class UserDataFactory  @Inject constructor(private val localUserEntityData: LocalUserEntityData,
private val networkUserEntityData: NetworkUserEntityData){
    fun create (source: Source) :ScheduleUserData {
        return when (source) {
            Source.NETWORK -> networkUserEntityData
            else -> localUserEntityData
        }
    }
}