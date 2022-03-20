package com.example.applicazionevera;

import android.app.Fragment;
import android.app.FragmentTransaction;
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
import com.google.android.material.navigation.NavigationView;
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
    String nome=null;
    String cognome=null;
    String email=null;
    int id;
    int idu;
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
            username = getIntent().getExtras().getString("username");
            password = getIntent().getExtras().getString("password");
            nome = getIntent().getExtras().getString("nome");
            cognome = getIntent().getExtras().getString("cognome");
            email = getIntent().getExtras().getString("email");
            idu=getIntent().getExtras().getInt("idutente");

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
                        openMappa();
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
        setData();
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
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        intent.putExtra("nome", nome);
        intent.putExtra("cognome", cognome);
        intent.putExtra("email", email);
        startActivity(intent);
    }
    public void openHome() {
        Intent HomeIntent = new Intent(this, Home.class);
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
    public void openCreaevento() {
        Intent intent = new Intent(this, CreaEvento.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        intent.putExtra("nome", nome);
        intent.putExtra("cognome", cognome);
        intent.putExtra("email", email);
        intent.putExtra("idutente", idu);
        startActivity(intent);
    }
    public void openEventoDettagliato() {
        Intent intent = new Intent(this, EventoDettagliato.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        intent.putExtra("nome", nome);
        intent.putExtra("cognome", cognome);
        intent.putExtra("email", email);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public void openMappa() {
        Intent intent = new Intent(this, PermissionsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onEventClick(int position) {
        id=events.get(position).getnumero_evento();
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





