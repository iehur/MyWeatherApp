package com.example.myweatherapp.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherModel {

    private String city;

    private String state;

    private Double latitude;

    private Double longitude;

    private String timezone;

    private CurrentWeatherModel currentWeatherModel;

    private List<DailyWeatherModel> dailyWeatherList = new ArrayList<>();

    private List<AlertModel> alerts = new ArrayList<>();

    //TODO(14) Initialize internal objects to JSON Object
    //Note: Can use DailyWeatherModel and CurrentWeatherModel Classes for reference
    public WeatherModel(String jsonString) throws JSONException {
        JSONObject object = new JSONObject(jsonString);
    }

    //TODO(15) Create Getter Methods for all internal objects
}
