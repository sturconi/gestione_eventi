package com.example.applicazionevera;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicazionevera.model_and_adapter.EvCatAdapter;
import com.example.applicazionevera.model_and_adapter.EvCatData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Evento extends AppCompatActivity implements EvCatAdapter.OnEventListener {

    private ArrayList<EvCatData> evcatData;
    String username = null;
    String password = null;
    String nome=null;
    String cognome=null;
    String email=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);

        username = getIntent().getExtras().getString("username");
        password = getIntent().getExtras().getString("password");
        nome = getIntent().getExtras().getString("nome");
        cognome = getIntent().getExtras().getString("cognome");
        email = getIntent().getExtras().getString("email");

        setArrayInfo();
        setData();


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


    }

    private void setArrayInfo() {
        evcatData = new ArrayList<>();
        evcatData.add(new EvCatData(R.drawable.duomo,"Calcetto pazzo sgravato","Via Fiorella Mannoia","28 FEB 2002"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_music_note_24, "Concerto di Antonio Lezzi","Via delle esplosioni","14 NOV 2015"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
        evcatData.add(new EvCatData(R.drawable.ic_baseline_fastfood_24,"In cucina con Ciccio","Piazzale Agricoltura","10 FEB 2022"));
      }


    private void setData() {
        RecyclerView recyclerViewO = (RecyclerView) findViewById(R.id.Evrc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Evento.this);
        EvCatAdapter adapter = new EvCatAdapter(evcatData, this::onEventClick);
        recyclerViewO.setHasFixedSize(true);
        recyclerViewO.setLayoutManager(new LinearLayoutManager(Evento.this));
        recyclerViewO.setNestedScrollingEnabled(false);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewO.getContext(), layoutManager.getOrientation());
        recyclerViewO.addItemDecoration(dividerItemDecoration);
        recyclerViewO.setAdapter(adapter);
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
    public void openEventoDettagliato() {
        Intent intent = new Intent(this, EventoDettagliato.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        intent.putExtra("nome", nome);
        intent.putExtra("cognome", cognome);
        intent.putExtra("email", email);
        startActivity(intent);
    }


    @Override
    public void onEventClick(int position) {
        openEventoDettagliato();
    }
}
