package com.example.myweatherapp.viewmodels;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

public class WeatherListViewModel extends ViewModel implements Response.Listener<String>, Response.ErrorListener {

    //TODO(2) Create List<WeatherModel> object and initialize it to ArrayList<>()
    //TODO(3) Create and initialize MutableLiveData<List<WeatherModel>> object
    //TODO(4) Create MutableLiveData<String> object to call when an Error occurs
    //TODO(5) Create getter method to return MutableLiveData<List<WeatherModel>> object
    //TODO(6) Create getter method to return MutableLiveData<String> Error object

    public void loadWeatherData(@NonNull Context context) {
        ArrayList<String> locations = new ArrayList<>();
        locations.add("Washington, DC");
        locations.add("Mountain View, CA");

        //TODO(14) Call method to send API request
    }

    //TODO(11) Create method with return type void which tells Provider Object to send API request

    @Override
    public void onErrorResponse(VolleyError error) {
        //TODO(12) Post value to MutableLiveData<String> Error object
        //Note: String value should indicate to user that there was an Error with the Request
    }

    @Override
    public void onResponse(String response) {
        //TODO(13) Handle String
    }
}
