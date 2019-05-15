package com.example.myweatherapp.models

import com.example.myweatherapp.R

object WeatherIconModel {

    val iconMapping: Map<String, Int> = mutableMapOf(
        "clear-day" to R.drawable.ic_clear_day,
        "clear-night" to R.drawable.ic_night_clear,
        "rain" to R.drawable.ic_rain,
        "snow" to R.drawable.ic_snow,
        "sleet" to R.drawable.ic_sleet,
        "wind" to R.drawable.ic_windy,
        "fog" to R.drawable.ic_fog,
        "cloudy" to R.drawable.ic_cloudy,
        "partly-cloudy-day" to R.drawable.ic_day_cloudy,
        "partly-cloudy-night" to R.drawable.ic_night_cloudy
    ).withDefault {
        R.drawable.ic_alien
    }

}