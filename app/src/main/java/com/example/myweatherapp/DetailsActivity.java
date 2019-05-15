package com.example.myweatherapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myweatherapp.models.WeatherModel;

import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.weatherIcon) ImageView weatherIcon;
    @BindView(R.id.location_tv) TextView tvLocation;
    @BindView(R.id.degree_tv) TextView tvDegrees;
    @BindView(R.id.weather_desc_tv) TextView tvWeatherDesc;
    @BindView(R.id.high_low_tv) TextView tvHighLow;
    @BindView(R.id.precipitation_tv) TextView tvPrecipitation;
    @BindView(R.id.windspeed_value_tv) TextView tvWindSpeed;
    @BindView(R.id.humidity_tv) TextView tvHumidity;
    @BindView(R.id.uvindex_tv) TextView tvUvIndex;
    @BindView(R.id.alert_tv) TextView tvAlert;

    private static final String WEATHER_MODEL_KEY = "details.weathermodel";

    private WeatherModel model;

    public static Intent getStartIntent(@NonNull Context context, @NonNull WeatherModel model) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(WEATHER_MODEL_KEY, model);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        if (model == null) {
            model = getIntent().getParcelableExtra(WEATHER_MODEL_KEY);
        }

        setupViews(model);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putParcelable(WEATHER_MODEL_KEY, model);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void setupViews(WeatherModel model) {
        weatherIcon.setImageResource(model.getCurrentWeatherModel().getIconDrawable());
        tvLocation.setText(String.format("%1$s, %2$s", model.getCity(), model.getState()));
        tvDegrees.setText(model.getCurrentWeatherModel().getTemperatureString());
        tvWeatherDesc.setText(model.getCurrentWeatherModel().getSummary());
        tvHighLow.setText(model.getDailyWeatherList().get(0).getHighlowString());
        tvPrecipitation.setText(model.getCurrentWeatherModel().getPrecipitationProbabilityString());
        tvWindSpeed.setText(model.getCurrentWeatherModel().getWindSpeedText());
        tvHumidity.setText(model.getCurrentWeatherModel().getHumidityString());
        tvUvIndex.setText(String.format(Locale.getDefault(), "%.0f", model.getCurrentWeatherModel().getUvIndex()));
        if (model.getAlerts() != null && model.getAlerts().size() > 0) {
            tvAlert.setText(model.getAlerts().get(0).getDescription());
        }
    }
}
