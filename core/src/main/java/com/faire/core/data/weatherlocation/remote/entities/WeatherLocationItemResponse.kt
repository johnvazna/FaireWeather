package com.faire.core.data.weatherlocation.remote.entities

data class WeatherLocationItemResponse(
    val id: String?,
    val weather_state_name: String?,
    val weather_state_abbr: String?,
    val wind_direction_compass: String?,
    val created: String?,
    val applicable_date: String?,
    val min_temp: Double?,
    val max_temp: Double?,
    val the_temp: Double?,
    val wind_speed: Double?,
    val wind_direction: Double?,
    val air_pressure: Double?,
    val humidity: Double?,
    val visibility: Double?,
    val predictability: Int?
)