package com.example.myweatherapp.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

import androidx.annotation.NonNull;

//TODO(11) Set class to implement as Parcelable
public class DailyWeatherModel {

    private Long time;

    private Double temperatureHigh;

    private Double temperatureLow;

    private String highlowString;

    DailyWeatherModel(@NonNull JSONObject object) throws JSONException {
        this.time = object.getLong("time");
        this.temperatureHigh = object.getDouble("temperatureHigh");
        this.temperatureLow = object.getDouble("temperatureLow");

        this.highlowString = String.format(
            Locale.getDefault(),
            "%1$.0fº/%2$.0fº",
            Math.ceil(temperatureHigh),
            Math.ceil(temperatureLow)
        );
    }

    public Long getTime() {
        return time;
    }

    public Double getTemperatureHigh() {
        return temperatureHigh;
    }

    public Double getTemperatureLow() {
        return temperatureLow;
    }

    public String getHighlowString() {
        return highlowString;
    }
}
