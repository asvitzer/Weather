package com.alvinsvitzer.weathervane.util

import android.util.Log
import java.net.URL

/**
 * Created by alvin.svitzer on 08/02/2018.
 */
class Request(val url: String){

    fun run(){
        //readText not good for huge responses. Change this if networking requests increase
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}