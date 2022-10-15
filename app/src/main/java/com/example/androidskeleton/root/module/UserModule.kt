package com.example.androidskeleton.root.module

import com.example.androidskeleton.data.schedule.repository.UserRepositoryImpl
import com.example.androidskeleton.domain.repository.UserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UserModule {
    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl) : UserDataRepository
}