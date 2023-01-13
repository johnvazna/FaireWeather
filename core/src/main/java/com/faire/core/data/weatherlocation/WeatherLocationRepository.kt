package com.faire.core.data.weatherlocation

import com.faire.core.data.weatherlocation.mapper.WeatherLocationListMapper
import com.faire.core.data.weatherlocation.remote.WeatherLocationRemoteDataSource
import com.faire.core.domain.weatherlocation.entities.WeatherLocation
import javax.inject.Inject
import com.faire.core.utils.Result
import com.faire.core.utils.map

class WeatherLocationRepository @Inject constructor(
    private val remoteDataSource: WeatherLocationRemoteDataSource,
    private val geWeatherLocationListMapper: WeatherLocationListMapper,
    ): WeatherLocationDataSource {

    override suspend fun getWeatherLocation(locationId: String): Result<WeatherLocation> =
        remoteDataSource.getWeatherLocation(locationId).map(geWeatherLocationListMapper::responseToDomain)
}
