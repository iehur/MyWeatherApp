package com.example.myweatherapp.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myweatherapp.models.WeatherModel;
import com.example.myweatherapp.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<WeatherModel> data;

    public MyAdapter(List<WeatherModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvCity.setText(data.get(position).getCity());
        holder.tvState.setText(data.get(position).getState());
        holder.tvDegrees.setText(data.get(position).getCurrentWeatherModel().getTemperatureString());
        holder.tvHighLow.setText(data.get(position).getDailyWeatherList().get(0).getHighlowString());
        holder.tvPrecipitation.setText(data.get(position).getCurrentWeatherModel().getPrecipitationProbabilityString());
        holder.icon.setImageResource(data.get(position).getCurrentWeatherModel().getIconDrawable());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.city_name_tv) TextView tvCity;
        @BindView(R.id.state_name_tv) TextView tvState;
        @BindView(R.id.degrees_tv) TextView tvDegrees;
        @BindView(R.id.weather_icon) ImageView icon;
        @BindView(R.id.high_low_tv) TextView tvHighLow;
        @BindView(R.id.precipitation_tv) TextView tvPrecipitation;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
