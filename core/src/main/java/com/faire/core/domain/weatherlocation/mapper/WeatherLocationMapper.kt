package com.faire.core.domain.weatherlocation.mapper

import com.faire.core.domain.Mapper
import com.faire.core.domain.weatherlocation.entities.WeatherLocation
import com.faire.core.domain.weatherlocation.entities.WeatherLocationItem
import com.faire.core.domain.weatherlocation.entities.WeatherLocationParent
import com.faire.core.domain.weatherlocation.entities.WeatherLocationSourceItem
import com.faire.core.ui.weatherlocation.WeatherLocationItemUI
import com.faire.core.ui.weatherlocation.WeatherLocationParentUI
import com.faire.core.ui.weatherlocation.WeatherLocationSourceItemUI
import com.faire.core.ui.weatherlocation.WeatherLocationUI
import javax.inject.Inject

class WeatherLocationListMapper @Inject constructor() :
    Mapper<WeatherLocation, WeatherLocationUI>() {

    override fun map(info: WeatherLocation) = WeatherLocationUI(
        weatherLocationItems(info.consolidated_weather),
        info.time,
        info.sun_rise,
        info.sun_set,
        info.timezone_name,
        weatherLocationParent(info.parent),
        weatherLocationSources(info.sources),
        info.title,
        info.location_type,
        info.woeid,
        info.latt_long,
        info.timezone
    )

    private fun weatherLocationItems(response: List<WeatherLocationItem>): MutableList<WeatherLocationItemUI> {
        val items = mutableListOf<WeatherLocationItemUI>()
        response.forEach {
            items.add(
                WeatherLocationItemUI(
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

    private fun weatherLocationParent(response: WeatherLocationParent) =
        WeatherLocationParentUI(
            response.title,
            response.location_type,
            response.woeid,
            response.latt_long
        )

    private fun weatherLocationSources(response: List<WeatherLocationSourceItem>): MutableList<WeatherLocationSourceItemUI> {
        val items = mutableListOf<WeatherLocationSourceItemUI>()
        response.forEach {
            items.add(
                WeatherLocationSourceItemUI(
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
