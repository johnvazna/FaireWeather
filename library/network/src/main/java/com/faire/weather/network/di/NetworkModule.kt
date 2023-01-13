package com.faire.weather.network.di

import com.faire.core.data.weatherlocation.remote.service.WeatherLocationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [BaseOkHttpModule::class])
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesWeatherLocationService(
        @Faire okHttpClient: OkHttpClient
    ) = provideService<WeatherLocationService>(okHttpClient)

    private fun providesRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder().addConverterFactory(
            GsonConverterFactory.create()
        )
            .baseUrl("https://cdn.faire.com/static/")
            .client(okHttpClient)
            .build()

    private inline fun <reified T : Any> provideService(
        okhttpClient: OkHttpClient
    ): T {
        return providesRetrofit(okhttpClient).create(T::class.java)
    }
}
