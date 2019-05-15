package com.example.myweatherapp.viewmodels;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.myweatherapp.networking.WeatherProvider;
import com.example.myweatherapp.models.LocationModel;
import com.example.myweatherapp.models.WeatherModel;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeatherListViewModel extends ViewModel implements Response.Listener<String>, Response.ErrorListener {

    private List<WeatherModel> data = new ArrayList<>();

    private MutableLiveData<List<WeatherModel>> weatherData = new MutableLiveData<>();

    private MutableLiveData<String> onError = new MutableLiveData<>();

    private Geocoder geocoder;

    public LiveData<List<WeatherModel>> getWeatherData() {
        return weatherData;
    }

    public LiveData<String> getOnError() {
        return onError;
    }

    public void loadWeatherData(@NonNull Context context) {
        try {
            ArrayList<String> locations = new ArrayList<>();
            locations.add("Washington, DC");
            locations.add("Mountain View, CA");

            List<LocationModel> locationModelData = getCoordinates(context, locations);
            for (LocationModel locationModel : locationModelData) {
                instantiateData(context, locationModel.getLatitude(), locationModel.getLongitude());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<LocationModel> getCoordinates(@NonNull Context context, List<String> locations) throws IOException {
        if (geocoder == null) {
            geocoder = new Geocoder(context);
        }

        List<LocationModel> locationModelData = new ArrayList<>();

        for (String location : locations) {
            List<Address> addresses = geocoder.getFromLocationName(location, 1);
            if (addresses != null && addresses.size() > 0) {
                Address tempAddress = addresses.get(0);
                LocationModel loc = new LocationModel(
                    tempAddress.getLatitude(),
                    tempAddress.getLongitude()
                );
                locationModelData.add(loc);
            }
        }

        return locationModelData;
    }

    private void setAddress(double latitude, double longitude, @NonNull WeatherModel data) throws IOException {

        List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
        if (addresses != null && addresses.size() > 0) {
            Address address = addresses.get(0);
            data.setCity(address.getLocality());
            data.setState(address.getAdminArea());
        }
    }

    private void instantiateData(@NonNull Context context, Double latitude, Double longitude) {
        loadData(context, latitude, longitude);
    }

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
            setAddress(weatherModel.getLatitude(), weatherModel.getLongitude(), weatherModel);
            data.add(weatherModel);
            weatherData.postValue(data);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
