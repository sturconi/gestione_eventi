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
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicazionevera.model_and_adapter.RecyclerViewAdapter;
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

public class Home extends AppCompatActivity implements RecyclerViewAdapter.OnEventListener{

    String username = null;
    String password = null;
    int statusCode;

    EventAdapter adapter = null;
    private List<Event> events=new ArrayList<>();
    MyApiEndpointInterface apiService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /*GloblalElite app = (GloblalElite) getApplicationContext();
        apiService = app.retrofit.create(MyApiEndpointInterface.class);*/

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
        Button bottone;
        bottone =(Button) findViewById(R.id.toCategorie);
        bottone.setOnClickListener(v -> openCategorie());


        bottone =(Button) findViewById(R.id.creaEvento);
        bottone.setOnClickListener(v -> openCreaevento());
        allEvent();
        //setFAKEInfo();
        setData();
    }



    private void setFAKEInfo() {
        for(int i=0;i<10;i++) {
            Event e = new Event("Prova", "Prova" + (i + 1), "Prova", "Prova", "Prova");
            events.add(e);
        }
    }

   private void setData() {
        RecyclerView recyclerViewOKL = (RecyclerView) findViewById(R.id.rc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Home.this);
        adapter = new EventAdapter(events, this::onEventClick);
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

    public void allEvent() {
        MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
        Call<List<Event>> call = apiService.getAllEvent();
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





