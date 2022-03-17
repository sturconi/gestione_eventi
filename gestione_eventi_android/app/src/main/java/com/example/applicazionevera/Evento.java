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
import com.example.applicazionevera.retrofit.Event;
import com.example.applicazionevera.retrofit.EventAdapter;
import com.example.applicazionevera.retrofit.MyApiEndpointInterface;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Evento extends AppCompatActivity implements EvCatAdapter.OnEventListener {

    private ArrayList<EvCatData> evcatData;
    String username = null;
    String password = null;
    String nome=null;
    String cognome=null;
    String email=null;
    String categoria=null;

    int statusCode;
    EventAdapter adapter = null;
    private List<Event> events=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);

        username = getIntent().getExtras().getString("username");
        password = getIntent().getExtras().getString("password");
        nome = getIntent().getExtras().getString("nome");
        cognome = getIntent().getExtras().getString("cognome");
        email = getIntent().getExtras().getString("email");
        categoria = getIntent().getExtras().getString("categoria");
        allEvent();
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
        RecyclerView recyclerViewOKL = (RecyclerView) findViewById(R.id.Evrc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Evento.this);
        adapter = new EventAdapter(events, this::onEventClick);
        recyclerViewOKL.setHasFixedSize(true);
        recyclerViewOKL.setLayoutManager(new LinearLayoutManager(Evento.this));
        recyclerViewOKL.setNestedScrollingEnabled(false);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewOKL.getContext(), layoutManager.getOrientation());
        recyclerViewOKL.addItemDecoration(dividerItemDecoration);
        recyclerViewOKL.setAdapter(adapter);
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

    public void allEvent() {
        MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
        Call<List<Event>> call = apiService.getEventBycat(categoria);
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                statusCode = response.code();
                events.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
            }
        });
    }

    public static final String BASE_URL = "http://10.0.2.2:8080/";
    Gson gson= new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
