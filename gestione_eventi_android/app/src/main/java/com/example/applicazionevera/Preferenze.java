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

    boolean switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferenze);
        SharedPreferences prefs;
        
        boolean value = false;
        Switch SwitchSpo = (Switch) findViewById(R.id.switchSport);
        Switch SwitchInt = (Switch) findViewById(R.id.switchIntr);
        Switch SwitchCul = (Switch) findViewById(R.id.switchCultura);
        Switch SwitchServ = (Switch) findViewById(R.id.switchServizi);
        /*GloblalElite csgo = ((GloblalElite) getApplicationContext());
        switchButton=csgo.getSwitchButton();

        if (switchButton==true){
            SwitchSpo.setChecked(true);

        }
        else{
            SwitchSpo.setChecked(false);
        }*/
        SharedPreferences luca =getSharedPreferences("salva", MODE_PRIVATE);
        SwitchSpo.setChecked(luca.getBoolean("value", true));

        SwitchSpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SwitchSpo.isChecked())  {
                    SharedPreferences.Editor editor = getSharedPreferences("salva", MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    SwitchSpo.setChecked(true);
                }
                else {
                    SharedPreferences.Editor editor = getSharedPreferences("salva", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    SwitchSpo.setChecked(false);
                }
            }
        });
        SharedPreferences mario =getSharedPreferences("salva2", MODE_PRIVATE);
        SwitchCul.setChecked(mario.getBoolean("value", true));
        SwitchCul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SwitchCul.isChecked())  {
                    SharedPreferences.Editor editor2 = getSharedPreferences("salva2", MODE_PRIVATE).edit();
                    editor2.putBoolean("value", true);
                    editor2.apply();
                    SwitchCul.setChecked(true);
                }
                else {
                    SharedPreferences.Editor editor2 = getSharedPreferences("salva2", MODE_PRIVATE).edit();
                    editor2.putBoolean("value", false);
                    editor2.apply();
                    SwitchCul.setChecked(false);
                }
            }
        });
        SharedPreferences luigi =getSharedPreferences("salva3", MODE_PRIVATE);
        SwitchInt.setChecked(luigi.getBoolean("value", true));
        SwitchInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SwitchInt.isChecked())  {
                    SharedPreferences.Editor editor3 = getSharedPreferences("salva3", MODE_PRIVATE).edit();
                    editor3.putBoolean("value", true);
                    editor3.apply();
                    SwitchInt.setChecked(true);
                }
                else {
                    SharedPreferences.Editor editor3 = getSharedPreferences("salva3", MODE_PRIVATE).edit();
                    editor3.putBoolean("value", false);
                    editor3.apply();
                    SwitchInt.setChecked(false);
                }
            }
        });
        SharedPreferences caio =getSharedPreferences("salva4", MODE_PRIVATE);
        SwitchServ.setChecked(caio.getBoolean("value", true));
        SwitchServ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SwitchServ.isChecked())  {
                    SharedPreferences.Editor editor4 = getSharedPreferences("salva4", MODE_PRIVATE).edit();
                    editor4.putBoolean("value", true);
                    editor4.apply();
                    SwitchServ.setChecked(true);
                }
                else {
                    SharedPreferences.Editor editor4 = getSharedPreferences("salva4", MODE_PRIVATE).edit();
                    editor4.putBoolean("value", false);
                    editor4.apply();
                    SwitchServ.setChecked(false);
                }
            }
        });


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
                    //csgo.setSwitchButton();
                } else {
                    SwitchSpo.setTextColor(Color.RED);
                  //  csgo.setSwitchButton();

                }
            }
        });

        SwitchInt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SwitchInt.isChecked() == true) {

                    SwitchInt.setTextColor(Color.GREEN);
                } else {
                    SwitchInt.setTextColor(Color.RED);

                }
            }
        });

        SwitchCul.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SwitchCul.isChecked() == true) {

                    SwitchCul.setTextColor(Color.GREEN);
                } else {
                    SwitchCul.setTextColor(Color.RED);

                }
            }
        });

        SwitchServ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SwitchServ.isChecked() == true) {

                    SwitchServ.setTextColor(Color.GREEN);
                } else {
                    SwitchServ.setTextColor(Color.RED);

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
