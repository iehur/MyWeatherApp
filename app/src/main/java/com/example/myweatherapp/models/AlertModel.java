package com.example.myweatherapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import androidx.annotation.NonNull;

public class AlertModel implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeValue(this.time);
        dest.writeValue(this.expirationTime);
        dest.writeString(this.description);
        dest.writeString(this.uri);
    }

    protected AlertModel(Parcel in) {
        this.title = in.readString();
        this.time = (Long) in.readValue(Long.class.getClassLoader());
        this.expirationTime = (Long) in.readValue(Long.class.getClassLoader());
        this.description = in.readString();
        this.uri = in.readString();
    }

    public static final Parcelable.Creator<AlertModel> CREATOR = new Parcelable.Creator<AlertModel>() {
        @Override
        public AlertModel createFromParcel(Parcel source) {
            return new AlertModel(source);
        }

        @Override
        public AlertModel[] newArray(int size) {
            return new AlertModel[size];
        }
    };
}
