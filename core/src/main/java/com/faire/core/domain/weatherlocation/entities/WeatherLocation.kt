package com.faire.core.domain.weatherlocation.entities

data class WeatherLocation(
    val consolidated_weather: List<WeatherLocationItem>,
    val time: String?,
    val sun_rise: String?,
    val sun_set: String?,
    val timezone_name: String?,
    val parent: WeatherLocationParent,
    val sources: List<WeatherLocationSourceItem>,
    val title: String?,
    val location_type: String?,
    val woeid: Int?,
    val latt_long: String?,
    val timezone: String?
)
