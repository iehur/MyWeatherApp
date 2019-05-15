package com.example.myweatherapp.models;

import org.json.JSONObject;

import androidx.annotation.NonNull;

//TODO(12) Set class to implement as Parcelable
public class AlertModel {

    private String title;

    private Long time;

    private Long expirationTime;

    private String description;

    private String uri;

    AlertModel(@NonNull JSONObject object) {
        this.title = object.optString("title");
        this.time = object.optLong("time");
        this.expirationTime = object.optLong("expires");
        this.description = object.optString("description");
        this.uri = object.optString("uri");
    }

    public String getTitle() {
        return title;
    }

    public Long getTime() {
        return time;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public String getDescription() {
        return description;
    }

    public String getUri() {
        return uri;
    }
}
