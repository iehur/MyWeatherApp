package com.example.myweatherapp.networking;

import android.content.Context;
import androidx.annotation.NonNull;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class WeatherProvider {

    private static WeatherProvider instance;

    private static final String requestKey = "[INSERT API KEY HERE]";

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
        String url = String.format("https://api.darksky.net/forecast/%1$s/%2$s,%3$s",requestKey,latitude, longitude);
        StringRequest request = new StringRequest(Request.Method.GET, url, successListener, errorListener);
        queue.add(request);
    }

}
