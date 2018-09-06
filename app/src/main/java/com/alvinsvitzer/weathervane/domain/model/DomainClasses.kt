package com.alvinsvitzer.weathervane.domain.model

/**
 * Created by alvin.svitzer on 08/02/2018.
 */
data class ForecastListDomain(val city: String, val country: String,
                              val dailyForecastDomain: List<ForecastDomain>)

data class ForecastDomain(val date: String, val description: String, val high: Int,
                          val low: Int)