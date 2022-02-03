package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    String username = null;
    String password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       Bundle datiLogin = getIntent().getExtras();
        if(datiLogin != null) {
            username = datiLogin.getString("user");
            password = datiLogin.getString("pwd");

            //if(username.length()>0 && password.length() >0)
                Toast.makeText(this, "Benvenuto " + username, Toast.LENGTH_SHORT).show();
        }

        ImageButton button;
        Button bottone;
        bottone =(Button) findViewById(R.id.toCategorie);
        bottone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategorie();
            }
        });
        bottone =(Button) findViewById(R.id.toCalendario);
        bottone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendario();
            }
        });
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
        bottone =(Button) findViewById(R.id.creaEvento);
        bottone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreaevento();
            }
        });

    }

    public void openCategorie() {
        Intent intent = new Intent(this, Categorie.class);
        startActivity(intent);
    }
    public void openCalendario() {
        Intent intent = new Intent(this, Calendario.class);
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
    public void openCreaevento() {
        Intent intent = new Intent(this, CreaEvento.class);
        startActivity(intent);
    }
}