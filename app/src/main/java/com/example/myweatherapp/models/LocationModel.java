package com.example.myweatherapp.models;

import androidx.annotation.NonNull;

public class LocationModel {

    private double latitude;

    private double longitude;

    public LocationModel(@NonNull Double latitude, @NonNull Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
