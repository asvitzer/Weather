package com.alvinsvitzer.weathervane.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.alvinsvitzer.weathervane.domain.model.ForecastListDomain

/**
 * Created by alvin.svitzer on 02/02/2018.
 */

class ForecastListAdapter(private val weekForecast: ForecastListDomain) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(weekForecast[position]){
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}