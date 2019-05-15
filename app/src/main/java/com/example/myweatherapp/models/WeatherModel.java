package com.example.myweatherapp.models;

import org.json.JSONArray;
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

    public WeatherModel(String jsonString) throws JSONException {
        JSONObject object = new JSONObject(jsonString);
        this.latitude = object.optDouble("latitude");
        this.longitude = object.optDouble("longitude");
        this.timezone = object.optString("timezone");
        this.currentWeatherModel = new CurrentWeatherModel(object.optJSONObject("currently"));

        JSONObject dailyWeather = object.optJSONObject("daily");
        JSONArray dailyDataList = dailyWeather.optJSONArray("data");
        for (int i = 0; i < dailyDataList.length(); i++) {
            dailyWeatherList.add(new DailyWeatherModel(dailyDataList.optJSONObject(i)));
        }

        JSONArray alertList = object.optJSONArray("alerts");
        if (alertList != null) {
            for (int i = 0; i < alertList.length(); i++) {
                alerts.add(new AlertModel(alertList.optJSONObject(i)));
            }
        }
    }

    //TODO(4) Create setter method for City string
    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    //TODO(5) Create setter method for State string
    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public CurrentWeatherModel getCurrentWeatherModel() {
        return currentWeatherModel;
    }

    public List<DailyWeatherModel> getDailyWeatherList() {
        return dailyWeatherList;
    }

    public List<AlertModel> getAlerts() {
        return alerts;
    }
}
