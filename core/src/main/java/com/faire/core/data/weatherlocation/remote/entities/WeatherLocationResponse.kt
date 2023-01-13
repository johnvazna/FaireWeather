package com.faire.core.data.weatherlocation.remote.entities

data class WeatherLocationResponse(
    val consolidated_weather: List<WeatherLocationItemResponse>,
    val time: String?,
    val sun_rise: String?,
    val sun_set: String?,
    val timezone_name: String?,
    val parent: WeatherLocationParentResponse,
    val sources: List<WeatherLocationSourceItemResponse>,
    val title: String?,
    val location_type: String?,
    val woeid: Int?,
    val latt_long: String?,
    val timezone: String?
)
