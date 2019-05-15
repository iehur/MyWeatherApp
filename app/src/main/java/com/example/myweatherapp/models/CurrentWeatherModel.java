package com.example.myweatherapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import java.util.Locale;

import androidx.annotation.NonNull;

public class CurrentWeatherModel implements Parcelable {

    private Long time;

    private String summary;

    private String icon;

    private Integer iconDrawable;

    private Double nearestStormDistance;

    private Double precipitationIntensity;

    private Double precipitationIntensityError;

    private Double precipitationProbability;

    private String precipitationProbabilityString;

    private String precipitationType;

    private Double temperature;

    private String temperatureString;

    private Double apparentTemperature;

    private Double dewPoint;

    private Double humidity;

    private String humidityString;

    private Double pressure;

    private Double windSpeed;

    private String windSpeedText;

    private Double windGust;

    private Double windBearing;

    private Double cloudCover;

    private Double uvIndex;

    private Double visibility;

    private Double ozone;

    CurrentWeatherModel(@NonNull JSONObject object) {
        this.time = object.optLong("time");
        this.summary = object.optString("summary");
        this.icon = object.optString("icon");
        this.iconDrawable = WeatherIconModel.INSTANCE.getIconMapping().get(this.icon);
        this.nearestStormDistance = object.optDouble("nearestStormDistance");
        this.precipitationIntensity = object.optDouble("precipIntensity");
        this.precipitationIntensityError = object.optDouble("precipIntensityError");
        this.precipitationProbability = object.optDouble("precipProbability") * 100;
        this.precipitationType = object.optString("precipType");
        this.temperature = Math.ceil(object.optDouble("temperature"));
        this.apparentTemperature = object.optDouble("apparentTemperature");
        this.dewPoint = object.optDouble("dewPoint");
        this.humidity = object.optDouble("humidity") * 100;
        this.pressure = object.optDouble("pressure");
        this.windSpeed = object.optDouble("windSpeed");
        this.windGust = object.optDouble("windGust");
        this.windBearing = object.optDouble("windBearing");
        this.cloudCover = object.optDouble("cloudCover");
        this.uvIndex = object.optDouble("uvIndex");
        this.visibility = object.optDouble("visibility");
        this.ozone = object.optDouble("ozone");

        this.precipitationProbabilityString = String.format(
            Locale.getDefault(),
            "%.0f%%",
            precipitationProbability
        );

        this.temperatureString = String.format(
            Locale.getDefault(),
            "%.0fº",
            this.temperature
        );

        this.windSpeedText = String.format(
            Locale.getDefault(),
            "%.0f MPH",
            Math.ceil(this.windSpeed)
        );

        this.humidityString = String.format(
            Locale.getDefault(),
            "%.0f%%",
            Math.ceil(this.humidity)
        );
    }

    public long getTime() {
        return time;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public Integer getIconDrawable() {
        return iconDrawable;
    }

    public Double getNearestStormDistance() {
        return nearestStormDistance;
    }

    public Double getPrecipitationIntensity() {
        return precipitationIntensity;
    }

    public Double getPrecipitationIntensityError() {
        return precipitationIntensityError;
    }

    public Double getPrecipitationProbability() {
        return precipitationProbability;
    }

    public String getPrecipitationProbabilityString() {
        return precipitationProbabilityString;
    }

    public String getPrecipitationType() {
        return precipitationType;
    }

    public Double getTemperature() {
        return temperature;
    }

    public String getTemperatureString() {
        return temperatureString;
    }

    public Double getApparentTemperature() {
        return apparentTemperature;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    public Double getHumidity() {
        return humidity;
    }

    public String getHumidityString() {
        return humidityString;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public String getWindSpeedText() {
        return windSpeedText;
    }

    public Double getWindGust() {
        return windGust;
    }

    public Double getWindBearing() {
        return windBearing;
    }

    public Double getCloudCover() {
        return cloudCover;
    }

    public Double getUvIndex() {
        return uvIndex;
    }

    public Double getVisibility() {
        return visibility;
    }

    public Double getOzone() {
        return ozone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.time);
        dest.writeString(this.summary);
        dest.writeString(this.icon);
        dest.writeInt(this.iconDrawable);
        dest.writeValue(this.nearestStormDistance);
        dest.writeValue(this.precipitationIntensity);
        dest.writeValue(this.precipitationIntensityError);
        dest.writeValue(this.precipitationProbability);
        dest.writeString(this.precipitationProbabilityString);
        dest.writeString(this.precipitationType);
        dest.writeValue(this.temperature);
        dest.writeString(this.temperatureString);
        dest.writeValue(this.apparentTemperature);
        dest.writeValue(this.dewPoint);
        dest.writeValue(this.humidity);
        dest.writeString(this.humidityString);
        dest.writeValue(this.pressure);
        dest.writeValue(this.windSpeed);
        dest.writeString(this.windSpeedText);
        dest.writeValue(this.windGust);
        dest.writeValue(this.windBearing);
        dest.writeValue(this.cloudCover);
        dest.writeValue(this.uvIndex);
        dest.writeValue(this.visibility);
        dest.writeValue(this.ozone);
    }

    protected CurrentWeatherModel(Parcel in) {
        this.time = in.readLong();
        this.summary = in.readString();
        this.icon = in.readString();
        this.iconDrawable = in.readInt();
        this.nearestStormDistance = (Double) in.readValue(Double.class.getClassLoader());
        this.precipitationIntensity = (Double) in.readValue(Double.class.getClassLoader());
        this.precipitationIntensityError = (Double) in.readValue(Double.class.getClassLoader());
        this.precipitationProbability = (Double) in.readValue(Double.class.getClassLoader());
        this.precipitationProbabilityString = in.readString();
        this.precipitationType = in.readString();
        this.temperature = (Double) in.readValue(Double.class.getClassLoader());
        this.temperatureString = in.readString();
        this.apparentTemperature = (Double) in.readValue(Double.class.getClassLoader());
        this.dewPoint = (Double) in.readValue(Double.class.getClassLoader());
        this.humidity = (Double) in.readValue(Double.class.getClassLoader());
        this.humidityString = in.readString();
        this.pressure = (Double) in.readValue(Double.class.getClassLoader());
        this.windSpeed = (Double) in.readValue(Double.class.getClassLoader());
        this.windSpeedText = in.readString();
        this.windGust = (Double) in.readValue(Double.class.getClassLoader());
        this.windBearing = (Double) in.readValue(Double.class.getClassLoader());
        this.cloudCover = (Double) in.readValue(Double.class.getClassLoader());
        this.uvIndex = (Double) in.readValue(Double.class.getClassLoader());
        this.visibility = (Double) in.readValue(Double.class.getClassLoader());
        this.ozone = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<CurrentWeatherModel> CREATOR = new Parcelable.Creator<CurrentWeatherModel>() {
        @Override
        public CurrentWeatherModel createFromParcel(Parcel source) {
            return new CurrentWeatherModel(source);
        }

        @Override
        public CurrentWeatherModel[] newArray(int size) {
            return new CurrentWeatherModel[size];
        }
    };
}
