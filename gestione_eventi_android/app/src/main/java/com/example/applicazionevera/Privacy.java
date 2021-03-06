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

public class Privacy extends AppCompatActivity {

    private Intent ServiceIntent;
    private Button btnstart, btnstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ServiceIntent = new Intent(getApplicationContext(), MyService.class);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.toSettings);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.toHome:
                        openHome();
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.toSearch:
                        openSearch();
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.toNotifications:
                        openNotifications();
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.toSettings:
                        openSettings();
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
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
}



