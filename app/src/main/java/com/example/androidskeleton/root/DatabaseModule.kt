package com.example.androidskeleton.root

import android.content.Context
import androidx.room.Room
import com.example.androidskeleton.data.SkeletonApplicationDatabase
import com.example.androidskeleton.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideSkeletonApplicationDatabase(@ApplicationContext appContext : Context) : SkeletonApplicationDatabase {
        return Room.databaseBuilder(
            appContext,
            SkeletonApplicationDatabase::class.java,
            Constants.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

//    @Provides
//    @Singleton
//    fun providePreferenceUtil(@ApplicationContext context: Context): PreferenceUtil {
//        return PreferenceUtil(context)
//    }


    @Provides
    @Singleton
    fun provideUserInfoDao(skeletonApplicationDatabase: SkeletonApplicationDatabase) = skeletonApplicationDatabase.userInfoDao()

}