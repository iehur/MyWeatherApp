package com.example.myweatherapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.example.myweatherapp.recyclerview.MyAdapter;
import com.example.myweatherapp.viewmodels.WeatherListViewModel;

public class MainActivity extends AppCompatActivity {

    //TODO(1) Create class object for RecyclerView and Bind it to view's id
    @BindView(R.id.loading_icon) ProgressBar loadingIcon;
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        //TODO(2) Setup RecyclerView object to have a fixed size
        //TODO(3) Create RecyclerView.LayoutManager object
        //TODO(4) Set RecyclerView object LayoutManager to created object

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            //TODO (EXTRA) Add new location to list
            Snackbar
                .make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        });

        WeatherListViewModel viewModel = ViewModelProviders.of(this).get(WeatherListViewModel.class);
        viewModel.getWeatherData().observe(this, weatherData -> {
            //TODO(14) Set RecyclerView Adapter to new Adapter class object from TODO(8)
            loadingIcon.setVisibility(View.GONE);
            //TODO(15) Set RecyclerView Visibility to VISIBLE
        });
        viewModel.getOnError().observe(this, this::showErrorDialog);

        viewModel.loadWeatherData(this);
    }

    private void showErrorDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
            .setMessage(message)
            .setTitle(R.string.dialog_title)
            .setPositiveButton(R.string.ok, (dialog, id) -> {
                // User clicked OK button
            });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}