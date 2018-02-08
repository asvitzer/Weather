package com.alvinsvitzer.weathervane.domain.commands

/**
 * Created by alvin.svitzer on 08/02/2018.
 */

interface Command<out T> {
    fun execute(): T
}