package com.alvinsvitzer.weathervane.domain.model

/**
 * Created by alvin.svitzer on 08/02/2018.
 */
data class ForecastList(val city: String, val country: String,
                        val dailyForecast: List<Forecast>)

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int)