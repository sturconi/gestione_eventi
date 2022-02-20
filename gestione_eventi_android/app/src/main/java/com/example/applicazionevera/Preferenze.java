package com.example.applicazionevera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Preferenze extends AppCompatActivity {

    boolean switchButtonSport;
    boolean switchButtonCul;
    boolean switchButtonInt;
    boolean switchButtonServ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferenze);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedPreferences prefs;
        
        boolean value = false;
        Switch SwitchSpo = (Switch) findViewById(R.id.switchSport);
        Switch SwitchInt = (Switch) findViewById(R.id.switchIntr);
        Switch SwitchCul = (Switch) findViewById(R.id.switchCultura);
        Switch SwitchServ = (Switch) findViewById(R.id.switchServizi);
        GloblalElite elite = ((GloblalElite) getApplicationContext());

        switchButtonSport=elite.getSwitchButtonSport();
        switchButtonCul=elite.getSwitchButtonCul();
        switchButtonInt=elite.getSwitchButtonInt();
        switchButtonServ=elite.getSwitchButtonServ();

        if (switchButtonSport==true){
            SwitchSpo.setChecked(true);

        }
        else{
            SwitchSpo.setChecked(false);
        }
        if (switchButtonCul==true){
            SwitchCul.setChecked(true);

        }
        else{
            SwitchCul.setChecked(false);
        }
        if (switchButtonInt==true){
            SwitchInt.setChecked(true);

        }
        else{
            SwitchInt.setChecked(false);
        }
        if (switchButtonServ==true){
            SwitchServ.setChecked(true);

        }
        else{
            SwitchServ.setChecked(false);
        }


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



        SwitchSpo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SwitchSpo.isChecked() == true) {

                    SwitchSpo.setTextColor(Color.GREEN);
                    elite.setSwitchButtonSport();
                } else {
                    SwitchSpo.setTextColor(Color.RED);
                    elite.setSwitchButtonSport();

                }
            }
        });

        SwitchInt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SwitchInt.isChecked() == true) {

                    SwitchInt.setTextColor(Color.GREEN);
                    elite.setSwitchButtonInt();
                } else {
                    SwitchInt.setTextColor(Color.RED);
                    elite.setSwitchButtonInt();

                }
            }
        });

        SwitchCul.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SwitchCul.isChecked() == true) {

                    SwitchCul.setTextColor(Color.GREEN);
                    elite.setSwitchButtonCul();
                } else {
                    SwitchCul.setTextColor(Color.RED);
                    elite.setSwitchButtonCul();

                }
            }
        });

        SwitchServ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SwitchServ.isChecked() == true) {

                    SwitchServ.setTextColor(Color.GREEN);
                    elite.setSwitchButtonServ();
                } else {
                    SwitchServ.setTextColor(Color.RED);
                    elite.setSwitchButtonServ();

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
}
