package com.faire.core.data.weatherlocation.remote

import com.faire.core.bases.BaseRemoteDataSource
import com.faire.core.data.weatherlocation.remote.service.WeatherLocationService
import javax.inject.Inject

class WeatherLocationRemoteDataSourceImpl @Inject constructor(
    private val service: WeatherLocationService
) : WeatherLocationRemoteDataSource, BaseRemoteDataSource() {

    override suspend fun getWeatherLocation(locationId: String) = getResult {
        service.getWeatherLocation(locationId)
    }
}
