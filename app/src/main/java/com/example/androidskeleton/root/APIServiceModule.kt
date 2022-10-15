package com.example.androidskeleton.root

import android.content.Context
import com.example.androidskeleton.data.schedule.api.UserDataAPIService
import com.example.androidskeleton.data.schedule.source.ScheduleUserData
import com.example.androidskeleton.data.schedule.source.local.LocalUserEntityData
import com.example.androidskeleton.utils.ErrorInterceptor
import com.example.androidskeleton.utils.PreferenceUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class APIServiceModule {
    @Provides
    @Singleton
    fun provideLoginAPIService(preferenceUtil: PreferenceUtil):UserDataAPIService {
        val okHttpClient = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS)

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient.addInterceptor(httpLoggingInterceptor)
        okHttpClient.addInterceptor(ErrorInterceptor())
        okHttpClient.readTimeout(60, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(60, TimeUnit.SECONDS)

        //val environment = preferenceUtil.getEnvironment()
        //val server = ServerEnvironment.getPlatformServer(environment)

        val retrofit = Retrofit.Builder()
            .client(okHttpClient.build())
            .baseUrl("https://server.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(UserDataAPIService::class.java)
    }


    @Provides
    @Singleton
    fun providePreferenceUtil(@ApplicationContext context: Context): PreferenceUtil {
        return PreferenceUtil(context)
    }

  //TODO now it is commented out
//    @Provides
//    @Singleton
//    fun provideUserApi(retrofit: Retrofit): UserDataAPIService = retrofit.create(UserDataAPIService::class.java)

//    @Provides
//    @Singleton
//    fun provideScheduleUserData(scheduleUserData: LocalUserEntityData): ScheduleUserData = scheduleUserData
}