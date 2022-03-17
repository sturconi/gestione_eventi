package com.example.applicazionevera;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applicazionevera.retrofit.Event;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class Categorie extends AppCompatActivity {

    String username =  null;
    String password = null ;
    String nome=null;
    String cognome=null;
    String email=null;
    String sport="sport";
    String cultura="cultura";
    String intrattenimento="intrattenimento";
    String servizi="servizi";
    int statusCode;
    List<Event> eve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username = getIntent().getExtras().getString("username");
        password = getIntent().getExtras().getString("password");
        nome = getIntent().getExtras().getString("nome");
        cognome = getIntent().getExtras().getString("cognome");
        email = getIntent().getExtras().getString("email");




        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
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

        Button bottoneSport,bottoneServizi,bottoneIntrattenimento,bottoneCultura;
        ImageButton button;

        bottoneSport=(Button)findViewById(R.id.toSport);
        bottoneSport.setOnClickListener(view -> SportEvents());


        bottoneCultura=(Button)findViewById(R.id.Cultura);
        bottoneCultura.setOnClickListener(view -> CulturaEvents());

        bottoneServizi=(Button)findViewById(R.id.Servizi);
        bottoneServizi.setOnClickListener(view -> ServiziEvents());

        bottoneIntrattenimento=(Button)findViewById(R.id.Intrattenimento);
        bottoneIntrattenimento.setOnClickListener(view -> IntrattenimentoEvents());
    }

    public void openHome() {
        Intent HomeIntent = new Intent(this, Home.class);
        HomeIntent.putExtra("username", username);
        HomeIntent.putExtra("password", password);
        HomeIntent.putExtra("nome", nome);
        HomeIntent.putExtra("cognome", cognome);
        HomeIntent.putExtra("email", email);
        startActivity(HomeIntent);
    }
    public void openSettings() {
        Intent intent = new Intent(this, Settings.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        intent.putExtra("nome", nome);
        intent.putExtra("cognome", cognome);
        intent.putExtra("email", email);
        startActivity(intent);
    }
    public void openNotifications() {
        Intent intent = new Intent(this, Notifiche.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        intent.putExtra("nome", nome);
        intent.putExtra("cognome", cognome);
        intent.putExtra("email", email);
        startActivity(intent);
    }

    public void openSearch() {
        Intent intent = new Intent(this, Search.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        intent.putExtra("nome", nome);
        intent.putExtra("cognome", cognome);
        intent.putExtra("email", email);
        startActivity(intent);
    }
    public void SportEvents() {
        Intent intent = new Intent(this, Evento.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        intent.putExtra("nome", nome);
        intent.putExtra("cognome", cognome);
        intent.putExtra("email", email);
        intent.putExtra("categoria", sport);
        startActivity(intent);
    }

    public void ServiziEvents() {
        Intent intent = new Intent(this, Evento.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        intent.putExtra("nome", nome);
        intent.putExtra("cognome", cognome);
        intent.putExtra("email", email);
        intent.putExtra("categoria", servizi);
        startActivity(intent);
    }

    public void CulturaEvents() {
        Intent intent = new Intent(this, Evento.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        intent.putExtra("nome", nome);
        intent.putExtra("cognome", cognome);
        intent.putExtra("email", email);
        intent.putExtra("categoria", cultura);
        startActivity(intent);
    }

    public void IntrattenimentoEvents() {
        Intent intent = new Intent(this, Evento.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        intent.putExtra("nome", nome);
        intent.putExtra("cognome", cognome);
        intent.putExtra("email", email);
        intent.putExtra("categoria", intrattenimento);
        startActivity(intent);
    }

}

