package com.example.androidskeleton.data.schedule.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserInfo(
    @PrimaryKey val userId: String,
    val email: String?,
    val firstName: String?,
    val lastName: String?,
    val name:String?,
    var status:Int
)
