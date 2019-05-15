package com.example.myweatherapp.viewmodels;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.myweatherapp.models.WeatherModel;
import com.example.myweatherapp.networking.WeatherProvider;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WeatherListViewModel extends ViewModel implements Response.Listener<String>, Response.ErrorListener {

    private List<WeatherModel> data = new ArrayList<>();

    private MutableLiveData<List<WeatherModel>> weatherData = new MutableLiveData<>();

    private MutableLiveData<String> onError = new MutableLiveData<>();

    //TODO(1) Create Geocoder class object

    public LiveData<List<WeatherModel>> getWeatherData() {
        return weatherData;
    }

    public LiveData<String> getOnError() {
        return onError;
    }

    public void loadWeatherData(@NonNull Context context) {
        ArrayList<String> locations = new ArrayList<>();
        locations.add("Washington, DC");
        locations.add("Mountain View, CA");

        //TODO(8) Create and initialize List<LocationModel> object to returned value from TODO(2)
        //TODO(9) Create For-loop to run through list of LocationModel objects and send API request(s)
    }

    //TODO(2) Create method which returns a List of LocationModels with arguments Context and List<String> of locations
    //TODO(3) Set method to initialize GeoCoder Object

    //TODO(6) Create method with arguments for (double) latitude, (double) longitude, and WeatherModel
    //TODO(7) Set method logic to set WeatherModel City and State to returned Address from GeoCoder Locality and AdminArea

    private void loadData(@NonNull Context context, Double latitude, Double longitude) {
        if (latitude != null && longitude != null) {
            WeatherProvider provider = WeatherProvider.getInstance(context);
            provider.sendRequest(latitude.toString(), longitude.toString(), this, this);
        } else {
            onError.postValue("Something went wrong. Please try again later.");
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        onError.postValue("Request failed. Please try again later.");
    }

    @Override
    public void onResponse(String response) {
        try {
            WeatherModel weatherModel = new WeatherModel(response);
            data.add(weatherModel);
            weatherData.postValue(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
