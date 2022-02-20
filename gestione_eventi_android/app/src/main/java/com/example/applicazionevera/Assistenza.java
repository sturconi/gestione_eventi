package com.example.applicazionevera;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Assistenza extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistenza);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



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

        Button button;
        button =(Button) findViewById(R.id.buttonInvia);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messaggio();
            }
        });
    }
    public void messaggio() {


    ImageButton button;
        button=(ImageButton) findViewById(R.id.toHome);
                button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        openHome();
        }
        });
        button=(ImageButton) findViewById(R.id.toSettings);
        button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        openSettings();
        }
        });
        button=(ImageButton) findViewById(R.id.toNotifications);
        button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        openNotifications();
        }
        });

        button=(ImageButton) findViewById(R.id.toSearch);
        button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        openSearch();
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