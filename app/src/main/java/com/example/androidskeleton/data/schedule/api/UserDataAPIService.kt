package com.example.androidskeleton.data.schedule.api

import com.example.androidskeleton.data.schedule.model.UserInfo
import retrofit2.http.GET

interface UserDataAPIService {
    @GET("/v2/times/this_month.json")
    suspend fun getPraySchedule(
    ): List<UserInfo>
}