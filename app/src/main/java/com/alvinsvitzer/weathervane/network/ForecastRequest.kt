package com.alvinsvitzer.weathervane.network

import android.util.Log
import com.alvinsvitzer.weathervane.data.ForecastResult
import java.net.URL

/**
 * Created by alvin.svitzer on 08/02/2018.
 */
class ForecastRequest(val zipCode: String) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" + "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun run() {
        //readText not good for huge responses. Change this if networking requests increase
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}