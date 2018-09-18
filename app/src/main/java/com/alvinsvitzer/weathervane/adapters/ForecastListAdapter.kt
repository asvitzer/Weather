package com.alvinsvitzer.weathervane.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alvinsvitzer.weathervane.R
import com.alvinsvitzer.weathervane.domain.model.ForecastDomain
import com.alvinsvitzer.weathervane.domain.model.ForecastListDomain
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.forecast_item_layout.view.*

/**
 * Created by alvin.svitzer on 02/02/2018.
 */

class ForecastListAdapter(private val weekForecast: ForecastListDomain,
                          private val itemClick: (ForecastDomain) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.forecast_item_layout, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size

    class ViewHolder(view: View, private val itemClick: (ForecastDomain) -> Unit)
        : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: ForecastDomain) {
            with(forecast) {
                Picasso.get().load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "${high}º"
                itemView.minTemperature.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    interface OnItemClickListener {
        operator fun invoke(forecast: ForecastDomain)
    }
}