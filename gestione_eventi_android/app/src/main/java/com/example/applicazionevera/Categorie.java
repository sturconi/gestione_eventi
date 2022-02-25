package com.example.applicazionevera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.applicazionevera.retrofit.Event;
import com.example.applicazionevera.retrofit.MyApiEndpointInterface;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Categorie extends AppCompatActivity {

    String categoria;
    int statusCode;
    List<Event> eve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



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
        bottoneSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoria="sport";
                cercaEvento();
            }
        });
        bottoneSport.setOnClickListener(view -> openEvento());

        bottoneCultura=(Button)findViewById(R.id.Cultura);
        bottoneCultura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoria="cultura";
                cercaEvento();
            }
        });
        bottoneCultura.setOnClickListener(view -> openEvento());

        bottoneServizi=(Button)findViewById(R.id.Servizi);
        bottoneServizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoria="servizi";
                cercaEvento();
            }
        });
        bottoneServizi.setOnClickListener(view -> openEvento());

        bottoneIntrattenimento=(Button)findViewById(R.id.Intrattenimento);
        bottoneIntrattenimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoria="intrattenimento";
                cercaEvento();
            }
        });
        bottoneIntrattenimento.setOnClickListener(view -> openEvento());
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
    public void openEvento() {
        Intent intent = new Intent(this, Evento.class);
        startActivity(intent);
    }

    public void cercaEvento() {
        MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
        Call<List<Event>> call = apiService.getEventBycat(categoria);
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                statusCode = response.code();
                eve = response.body();
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
            }
        });
    }

    public static final String BASE_URL = "http://10.0.2.2:8080/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}

