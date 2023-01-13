package com.faire.weather.network.di

import com.faire.weather.network.OkHttpHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BaseOkHttpModule {

    @Singleton
    @Provides
    fun providesOkHttpClient() = OkHttpHelper.getOkHttpBuilder()
}
