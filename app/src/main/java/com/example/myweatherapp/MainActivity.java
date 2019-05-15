package com.example.myweatherapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.Menu;
import android.view.MenuItem;

import com.example.myweatherapp.viewmodels.WeatherListViewModel;

public class MainActivity extends AppCompatActivity {

    //TODO(16) create reference object to access loading icon view found in layout
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            //TODO (EXTRA) Add new location to list
            Snackbar
                .make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        });

        WeatherListViewModel viewModel = ViewModelProviders.of(this).get(WeatherListViewModel.class);

        //TODO(17) Observe List of Weather LiveData object in ViewModel
        //TODO(18) Observe Error LiveData object in ViewModel
        //TODO(21) Call method which creates dialog and pass message object

        //TODO(19) Call ViewModel method to initiate calling the Weather API
    }

    //TODO(20) Create method with a String object argument and creates an Alert Dialog with the message

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