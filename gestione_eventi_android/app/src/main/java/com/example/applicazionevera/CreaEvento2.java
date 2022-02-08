package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class CreaEvento2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_evento_2);

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

    }
}