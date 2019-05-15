package com.example.myweatherapp.networking;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import androidx.annotation.NonNull;

public class WeatherProvider {

    private static WeatherProvider instance;

    //TODO(7) Set key String value to respective DarkSky API Key
    private static final String requestKey = "";

    private RequestQueue queue;

    private WeatherProvider(@NonNull Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public static WeatherProvider getInstance(@NonNull Context context) {
        if (instance == null) {
            synchronized (WeatherProvider.class) {
                if (instance == null) {
                    instance = new WeatherProvider(context);
                }
            }
        }

        return instance;
    }

    public void sendRequest(String latitude, String longitude,
        Response.Listener<String> successListener, Response.ErrorListener errorListener) {
        //TODO(8) Initialize String URL object to send DarkSky API request
        //TODO(9) Initialize StringRequest Object to send GET request, url, and both listeners
        //TODO(10) Add request object to queue
    }

    public void clearInstance() {
        instance = null;
    }

}
