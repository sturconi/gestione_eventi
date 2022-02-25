package com.example.applicazionevera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.applicazionevera.model_and_adapter.MyService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Privacy extends AppCompatActivity implements View.OnClickListener{

    private Intent ServiceIntent;
    private Button btnstart, btnstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    btnstart = findViewById(R.id.startmus);
    btnstop = findViewById(R.id.stopmus);
    btnstart.setOnClickListener(this);
    btnstop.setOnClickListener(this);

    ServiceIntent = new Intent(getApplicationContext(), MyService.class);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.toSettings);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.toHome:
                        openHome();
                        overridePendingTransition(0,0);
                        break;
                    case R.id.toSearch:
                        openSearch();
                        overridePendingTransition(0,0);
                        break;
                    case R.id.toNotifications:
                        openNotifications();
                        overridePendingTransition(0,0);
                        break;
                    case R.id.toSettings:
                        openSettings();
                        overridePendingTransition(0,0);
                        break;
                }
                return false;
            }
        });


        ToggleButton ToggleGps = (ToggleButton) findViewById(R.id.ToggleGps);
        ToggleButton ToggleNC = (ToggleButton) findViewById(R.id.ToggleNC);

        ToggleGps.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ToggleGps.isChecked() == true) {

                    ToggleGps.setTextColor(Color.GREEN);
                } else {
                    ToggleGps.setTextColor(Color.RED);

                }
            }
        });

        ToggleNC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ToggleNC.isChecked() == true) {

                    ToggleNC.setTextColor(Color.GREEN);
                } else {
                    ToggleNC.setTextColor(Color.RED);

                }
            }
        });


    }



    public void openHome() {
        Intent HomeIntent = new Intent(this, Home.class);
        startActivity(HomeIntent);
    }
    public void openSettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
    public void openNotifications() {
        Intent intent = new Intent(this, Notifiche.class);
        startActivity(intent);
    }

    public void openSearch() {
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startmus:
                startService(new Intent(getApplicationContext(), MyService.class));
                break;
            case R.id.stopmus:
                stopService(new Intent(getApplicationContext(), MyService.class));
                break;
        }
    }
}


