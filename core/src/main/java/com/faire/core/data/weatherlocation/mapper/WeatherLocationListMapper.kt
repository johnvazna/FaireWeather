package com.faire.core.data.weatherlocation.mapper

import com.faire.core.data.weatherlocation.remote.entities.WeatherLocationItemResponse
import com.faire.core.data.weatherlocation.remote.entities.WeatherLocationParentResponse
import com.faire.core.data.weatherlocation.remote.entities.WeatherLocationResponse
import com.faire.core.data.weatherlocation.remote.entities.WeatherLocationSourceItemResponse
import com.faire.core.domain.weatherlocation.entities.WeatherLocation
import com.faire.core.domain.weatherlocation.entities.WeatherLocationItem
import com.faire.core.domain.weatherlocation.entities.WeatherLocationParent
import com.faire.core.domain.weatherlocation.entities.WeatherLocationSourceItem
import javax.inject.Inject

class WeatherLocationListMapper @Inject constructor() {

    fun responseToDomain(response: WeatherLocationResponse) = WeatherLocation(
        responseWeatherLocationItems(response.consolidated_weather),
        response.time,
        response.sun_rise,
        response.sun_set,
        response.timezone_name,
        responseWeatherLocationParent(response.parent),
        responseWeatherLocationSources(response.sources),
        response.title,
        response.location_type,
        response.woeid,
        response.latt_long,
        response.timezone
    )

    private fun responseWeatherLocationItems(response: List<WeatherLocationItemResponse>): MutableList<WeatherLocationItem> {
        val items = mutableListOf<WeatherLocationItem>()
        response.forEach {
            items.add(
                WeatherLocationItem(
                    it.id,
                    it.weather_state_name,
                    it.weather_state_abbr,
                    it.wind_direction_compass,
                    it.created,
                    it.applicable_date,
                    it.min_temp,
                    it.max_temp,
                    it.the_temp,
                    it.wind_speed,
                    it.wind_direction,
                    it.air_pressure,
                    it.humidity,
                    it.visibility,
                    it.predictability
                )
            )
        }
        return items.toMutableList()
    }

    private fun responseWeatherLocationParent(response: WeatherLocationParentResponse) =
        WeatherLocationParent(
            response.title,
            response.location_type,
            response.woeid,
            response.latt_long
        )

    private fun responseWeatherLocationSources(response: List<WeatherLocationSourceItemResponse>): MutableList<WeatherLocationSourceItem> {
        val items = mutableListOf<WeatherLocationSourceItem>()
        response.forEach {
            items.add(
                WeatherLocationSourceItem(
                    it.title,
                    it.slug,
                    it.url,
                    it.crawl_rate
                )
            )
        }
        return items.toMutableList()
    }
}
