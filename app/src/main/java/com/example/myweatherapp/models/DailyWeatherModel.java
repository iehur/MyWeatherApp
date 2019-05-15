package com.example.myweatherapp.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class DailyWeatherModel implements Parcelable {

    private Long time;

    private Double temperatureHigh;

    private Double temperatureLow;

    private String highlowString;

    DailyWeatherModel(@NonNull JSONObject object) throws JSONException {
        this.time = object.getLong("time");
        this.temperatureHigh = object.getDouble("temperatureHigh");
        this.temperatureLow = object.getDouble("temperatureLow");
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
        if (TextUtils.isEmpty(highlowString)) {
            highlowString = String.format(
                Locale.getDefault(),
                "%1$.0fº/%2$.0fº",
                Math.ceil(temperatureHigh),
                Math.ceil(temperatureLow)
            );
        }
        return highlowString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.time);
        dest.writeValue(this.temperatureHigh);
        dest.writeValue(this.temperatureLow);
        dest.writeString(this.highlowString);
    }

    protected DailyWeatherModel(Parcel in) {
        this.time = (Long) in.readValue(Long.class.getClassLoader());
        this.temperatureHigh = (Double) in.readValue(Double.class.getClassLoader());
        this.temperatureLow = (Double) in.readValue(Double.class.getClassLoader());
        this.highlowString = in.readString();
    }

    public static final Creator<DailyWeatherModel> CREATOR = new Creator<DailyWeatherModel>() {
        @Override
        public DailyWeatherModel createFromParcel(Parcel source) {
            return new DailyWeatherModel(source);
        }

        @Override
        public DailyWeatherModel[] newArray(int size) {
            return new DailyWeatherModel[size];
        }
    };
}
