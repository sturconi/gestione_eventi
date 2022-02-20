package com.example.applicazionevera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Account extends AppCompatActivity {

    String username =  null;
    String password = null ;

    TextView user=null;
    TextView pass=null;
    ImageView img=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
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

        user=findViewById(R.id.userTextView);
        pass=findViewById(R.id.passTextView);
        img=findViewById(R.id.imgView);

        user.setText(getIntent().getStringExtra("username"));
        pass.setText(getIntent().getStringExtra("password"));
        Button bottone;

        bottone  = (Button) findViewById(R.id.CambioPass);
        bottone.setOnClickListener(view -> openCambioPass());

        bottone  = (Button) findViewById(R.id.ModImm);
        bottone.setOnClickListener(view -> openModImm());
        bottone  = (Button) findViewById(R.id.buttonLogout);
        bottone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences prefs = getSharedPreferences("MY_PREFERENCES", Context.MODE_PRIVATE);
                SharedPreferences.Editor  editor  =  prefs.edit();
                String us= "";
                String pas= "";
                String usern= prefs.getString(us,  "");
                String passw= prefs.getString(pas,  "");
                editor.commit();
                openLogin();
            }
        });


    }

    public void openCambioPass() {
        Intent intent = new Intent(this, Cambiopassword.class);
        startActivity(intent);
    }
    public void openModImm() {
        Intent intent = new Intent(this,Modificaimmagine.class);
        startActivity(intent);
    }
    public void openRegistrazione() {
        Intent intent = new Intent(this,Registrazione.class);
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

    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void openSearch() {
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }
}