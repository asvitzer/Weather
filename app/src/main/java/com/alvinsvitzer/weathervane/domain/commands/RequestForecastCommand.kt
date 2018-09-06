package com.alvinsvitzer.weathervane.domain.commands

import com.alvinsvitzer.weathervane.domain.mappers.ForecastDataMapper
import com.alvinsvitzer.weathervane.domain.model.ForecastListDomain
import com.alvinsvitzer.weathervane.network.ForecastRequest

class RequestForecastCommand(private val zipCode: String) : Command<ForecastListDomain> {

    override fun execute(): ForecastListDomain {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.run())
    }


}