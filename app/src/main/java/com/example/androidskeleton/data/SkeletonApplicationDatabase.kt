package com.example.androidskeleton.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidskeleton.data.schedule.model.UserInfo
import com.example.androidskeleton.data.schedule.room.dao.UserInfoDao
import com.example.androidskeleton.utils.Constants


@Database(
    entities = [
        UserInfo::class
               ], version = Constants.DATABASE_VERSION, exportSchema = false
)
abstract class SkeletonApplicationDatabase : RoomDatabase() {
    abstract fun userInfoDao(): UserInfoDao
}