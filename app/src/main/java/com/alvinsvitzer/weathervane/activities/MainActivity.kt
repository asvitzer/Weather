package com.alvinsvitzer.weathervane.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.alvinsvitzer.weathervane.R
import com.alvinsvitzer.weathervane.adapters.ForecastListAdapter
import com.alvinsvitzer.weathervane.domain.commands.RequestForecastCommand
import com.alvinsvitzer.weathervane.network.ForecastRequest
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.Android
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecast_recycler_view.layoutManager = LinearLayoutManager(this)

        doAsync {

            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecast_recycler_view.adapter = ForecastListAdapter(result)
            }
        }
    }
}
