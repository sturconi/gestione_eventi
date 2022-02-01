package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Privacy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        Toast.makeText(this, "privacy", Toast.LENGTH_SHORT).show();

        ToggleButton ToggleGps = (ToggleButton) findViewById(R.id.ToggleGps);
        ToggleButton ToggleNC = (ToggleButton) findViewById(R.id.ToggleNC);

        ToggleGps.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ToggleGps.isChecked() == true) {
                    Toast.makeText(Privacy.this, "Gps Attivato!", Toast.LENGTH_LONG).show();
                    ToggleGps.setTextColor(Color.GREEN);
                } else {
                    ToggleGps.setTextColor(Color.RED);
                    Toast.makeText(Privacy.this, "Gps Disattivato!", Toast.LENGTH_LONG).show();
                }
            }
        });

        ToggleNC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ToggleNC.isChecked() == true) {
                    Toast.makeText(Privacy.this, "Nome e cognome attivati!", Toast.LENGTH_LONG).show();
                    ToggleNC.setTextColor(Color.GREEN);
                } else {
                    ToggleNC.setTextColor(Color.RED);
                    Toast.makeText(Privacy.this, "Nome e cognome nascosti!", Toast.LENGTH_LONG).show();
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


