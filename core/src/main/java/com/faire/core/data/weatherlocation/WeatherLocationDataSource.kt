package com.faire.core.data.weatherlocation

import com.faire.core.domain.weatherlocation.entities.WeatherLocation
import com.faire.core.utils.Result

interface WeatherLocationDataSource {

    suspend fun getWeatherLocation(locationId: String): Result<WeatherLocation>
}
