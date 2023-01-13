package com.faire.core.data.weatherlocation.remote

import com.faire.core.data.weatherlocation.remote.entities.WeatherLocationResponse
import com.faire.core.utils.Result

interface WeatherLocationRemoteDataSource {

    suspend fun getWeatherLocation(locationId: String): Result<WeatherLocationResponse>
}
