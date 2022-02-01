package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Modificaimmagine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificaimmagine);
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
