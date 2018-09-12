package com.alvinsvitzer.weathervane.domain.mappers

import com.alvinsvitzer.weathervane.data.Forecast
import com.alvinsvitzer.weathervane.data.ForecastResult
import com.alvinsvitzer.weathervane.domain.model.ForecastListDomain
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import com.alvinsvitzer.weathervane.domain.model.ForecastDomain as ModelForecast

/**
 * Created by alvin.svitzer on 08/02/2018.
 */
 class ForecastDataMapper {

     fun convertFromDataModel(forecast: ForecastResult): ForecastListDomain {
         return ForecastListDomain(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
         }

     private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
         return list.mapIndexed { i, forecast ->
             val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
             convertForecastItemToDomain(forecast.copy(dt = dt))
            }
         }

     private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
         return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
         forecast.temp.max.toInt(), forecast.temp.min.toInt(),  generateIconUrl(forecast.weather[0].icon))
         }

     private fun convertDate(date: Long): String {
         val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
         return df.format(date)
         }

    private fun generateIconUrl(iconCode: String): String = "“http://openweathermap.org/img/w/$iconCode.png”\n"
     }