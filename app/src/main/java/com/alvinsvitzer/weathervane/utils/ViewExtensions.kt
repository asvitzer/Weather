package com.alvinsvitzer.weathervane.utils

import android.content.Context
import android.view.View

class ViewExtensions {

    val View.ctx: Context
        get() = context
}