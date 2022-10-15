package com.example.androidskeleton.data.schedule.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidskeleton.data.schedule.model.UserInfo


@Dao
interface UserInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: List<UserInfo>)

    @Query("SELECT * FROM UserInfo")
    fun getPraySchedule(): List<UserInfo>
}