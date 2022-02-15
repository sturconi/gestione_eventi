package com.example.applicazionevera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicazionevera.retrofit.PreferenceHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.zip.Inflater;

public class Home extends AppCompatActivity {

    String username = null;
    String password = null;

    private PreferenceHelper preferenceHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        preferenceHelper = new PreferenceHelper(this);








        /* CUSTOM LOGO PERSONALIZZATO
    androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();


    actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater= (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.custom_image, null);
        actionBar.setCustomView(view);


*/

        Button b;

        b =(Button) findViewById(R.id.toCalendario);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal = Calendar.getInstance();
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("beginTime", cal.getTimeInMillis());
                intent.putExtra("allDay", true);
                intent.putExtra("rrule", "FREQ=YEARLY");
                intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
                intent.putExtra("title", "Sei stato eventato ;-)" );
                startActivity(intent);

            }
        });



        Bundle datiLogin = getIntent().getExtras();
        if(datiLogin != null) {
            username = datiLogin.getString("user");
            password = datiLogin.getString("pwd");


        }




        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        navigation.setSelectedItemId(R.id.toHome);

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



        ImageButton button;
        Button bottone;
        bottone =(Button) findViewById(R.id.toCategorie);
        bottone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategorie();
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