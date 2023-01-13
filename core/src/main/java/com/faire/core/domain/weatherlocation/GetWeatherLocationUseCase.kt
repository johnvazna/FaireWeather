package com.faire.core.domain.weatherlocation

import com.faire.core.data.weatherlocation.WeatherLocationDataSource
import com.faire.core.domain.SuspendUseCase
import com.faire.core.domain.weatherlocation.entities.WeatherLocation
import com.faire.core.domain.weatherlocation.mapper.WeatherLocationListMapper
import com.faire.core.ui.weatherlocation.WeatherLocationUI
import com.faire.core.utils.Result
import com.faire.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetWeatherLocationUseCase @Inject constructor(
    private val weatherLocationDataSource: WeatherLocationDataSource,
    @IoDispatcher dispatcher: CoroutineDispatcher,
    mapper: WeatherLocationListMapper
) : SuspendUseCase<String, WeatherLocationUI, WeatherLocation>(dispatcher, mapper) {

    override suspend fun execute(parameters: String): Result<WeatherLocation> =
        weatherLocationDataSource.getWeatherLocation(parameters)
}
