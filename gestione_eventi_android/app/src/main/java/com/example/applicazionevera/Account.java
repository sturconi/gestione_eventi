package com.example.applicazionevera;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);



        user=findViewById(R.id.userTextView);
        pass=findViewById(R.id.passTextView);
        img=findViewById(R.id.imgView);


        Bundle datiLogin = getIntent().getExtras();
        if(datiLogin != null) {
             username = datiLogin.getString("user");
             password = datiLogin.getString("pwd");
             user.setText(username);
             pass.setText(password);

        }




        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.toHome:
                        openHome();
                        break;
                    case R.id.toSearch:
                        openSearch();
                        break;
                    case R.id.toNotifications:
                        openNotifications();
                        break;
                    case R.id.toSettings:
                        openSettings();
                        break;
                }
                return false;
            }
        });

        Button bottone;

        bottone  = (Button) findViewById(R.id.CambioPass);
        bottone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCambioPass();
            }
        });

        bottone  = (Button) findViewById(R.id.ModImm);
        bottone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openModImm();
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