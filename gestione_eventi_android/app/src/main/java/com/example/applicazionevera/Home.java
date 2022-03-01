package com.example.applicazionevera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.example.applicazionevera.model_and_adapter.MyData;
import com.example.applicazionevera.model_and_adapter.RecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements RecyclerViewAdapter.OnEventListener {

    String username = null;
    String password = null;

    private ArrayList<MyData> myData;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        GloblalElite app = (GloblalElite) getApplication();
        app.startLocation();

        setArrayInfo();
        setData();




    androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();


    actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater= (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.custom_image, null);
        actionBar.setCustomView(view);





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
        bottone.setOnClickListener(v -> openCategorie());


        bottone =(Button) findViewById(R.id.creaEvento);
        bottone.setOnClickListener(v -> openCreaevento());

    }


    private void setArrayInfo() {
        myData = new ArrayList<>();
             myData.add(new MyData(R.drawable.duomo,"20","4.3","Calcetto pazzo sgravato","via Risorgimento, Milano","28 FEB 2002"));
             myData.add(new MyData(R.drawable.ic_baseline_music_note_24,"20","4.3","Concerto di Ariana Grande","Via delle esplosioni","14 NOV 2015"));
             myData.add(new MyData(R.drawable.ic_baseline_fastfood_24,"20","4.3","Gino il pasticciere","Piazzale Agricoltura","28 FEB 2002"));
             myData.add(new MyData(R.drawable.ic_baseline_sports_basketball_24,"20","4.3","NBA All Star Game","Green street","28 FEB 2002"));
             myData.add(new MyData(R.drawable.ic_baseline_museum_24,"20","4.3","Museo dei paguri","Via kekkobomba","28 FEB 2002"));
        }


    private void setData() {
        RecyclerView recyclerViewOKL = (RecyclerView) findViewById(R.id.rc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Home.this);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(myData, this::onEventClick);
        recyclerViewOKL.setHasFixedSize(true);
        recyclerViewOKL.setLayoutManager(new LinearLayoutManager(Home.this));
        recyclerViewOKL.setNestedScrollingEnabled(false);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewOKL.getContext(), layoutManager.getOrientation());
        recyclerViewOKL.addItemDecoration(dividerItemDecoration);
        recyclerViewOKL.setAdapter(adapter);
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
    public void openEventoDettagliato() {
        //Intent intent = new Intent(this, EventoDettagliato.class);
        Intent intent = new Intent(this, EventoDettagliato.class);
        startActivity(intent);
    }

    @Override
    public void onEventClick(int position) {
        openEventoDettagliato();

    }


}