package com.example.applicazionevera;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Settings<button> extends AppCompatActivity {
    String username = null;
    String password = null;
    String nome=null;
    String cognome=null;
    String email=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater= (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.custom_image, null);
        actionBar.setCustomView(view);

        username = getIntent().getExtras().getString("username");
        password = getIntent().getExtras().getString("password");
        nome = getIntent().getExtras().getString("nome");
        cognome = getIntent().getExtras().getString("cognome");
        email = getIntent().getExtras().getString("email");



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
        button = (Button) findViewById(R.id.Preferenze);
        button.setOnClickListener(v -> openPreferenza());

        button = (Button) findViewById(R.id.Notifiche);
        button.setOnClickListener(v -> openNotifiche());

        button = (Button) findViewById(R.id.Account);
        button.setOnClickListener(v -> openAccount());

        button = (Button) findViewById(R.id.Assistenza);
        button.setOnClickListener(v -> openAssistenza());

        button = (Button) findViewById(R.id.Privacy);
        button.setOnClickListener(v -> openPrivacy());



    }


    public void openPreferenza() {
        Intent intent = new Intent(this, Preferenze.class);
        startActivity(intent);
    }
    public void openNotifiche() {
        Intent intent = new Intent(this, Notifiche.class);
        startActivity(intent);
    }
    public void openAccount() {
        Intent intent = new Intent(this, Account.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        intent.putExtra("nome", nome);
        intent.putExtra("cognome", cognome);
        intent.putExtra("email", email);
        startActivity(intent);
    }
    public void openAssistenza() {
        Intent intent = new Intent(this, Assistenza.class);
        startActivity(intent);
    }
    public void openPrivacy() {
        Intent intent = new Intent(this, Privacy.class);
        startActivity(intent);
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


