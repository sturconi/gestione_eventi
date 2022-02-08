package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class Preferenze extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferenze);

        Switch SwitchSpo = (Switch) findViewById(R.id.switchSport);
        Switch SwitchInt = (Switch) findViewById(R.id.switchIntr);
        Switch SwitchCul = (Switch) findViewById(R.id.switchCultura);
        Switch SwitchServ = (Switch) findViewById(R.id.switchServizi);

        SwitchSpo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (SwitchSpo.isChecked() == true) {

                    SwitchSpo.setTextColor(Color.GREEN);
                } else {
                    SwitchSpo.setTextColor(Color.RED);

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
