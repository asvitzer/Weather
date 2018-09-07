package com.alvinsvitzer.weathervane.domain.model

import com.alvinsvitzer.weathervane.data.Forecast

/**
 * Created by alvin.svitzer on 08/02/2018.
 */
data class ForecastListDomain(val city: String, val country: String,
                              val dailyForecastDomain: List<ForecastDomain>) {

    val size: Int
        get() = dailyForecastDomain.size

    operator fun get(position: Int): ForecastDomain = dailyForecastDomain[position]
}

data class ForecastDomain(val date: String, val description: String, val high: Int,
                          val low: Int)