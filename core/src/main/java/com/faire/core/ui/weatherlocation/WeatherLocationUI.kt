package com.faire.core.ui.weatherlocation

data class WeatherLocationUI(
    val consolidated_weather: List<WeatherLocationItemUI>,
    val time: String?,
    val sun_rise: String?,
    val sun_set: String?,
    val timezone_name: String?,
    val parent: WeatherLocationParentUI,
    val sources: List<WeatherLocationSourceItemUI>,
    val title: String?,
    val location_type: String?,
    val woeid: Int?,
    val latt_long: String?,
    val timezone: String?
)
