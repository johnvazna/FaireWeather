package com.faire.core.data.weatherlocation.remote.service

import com.faire.core.data.weatherlocation.remote.entities.WeatherLocationResponse
import retrofit2.http.GET

interface WeatherLocationService {

    @GET("mobile-take-home/4418.json")
    suspend fun getWeatherLocation(locationId: String): WeatherLocationResponse
}
