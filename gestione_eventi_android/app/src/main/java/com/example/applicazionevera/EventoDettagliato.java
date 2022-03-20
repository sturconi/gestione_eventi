package com.example.applicazionevera;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.applicazionevera.retrofit.Event;
import com.example.applicazionevera.retrofit.MyApiEndpointInterface;
import com.example.applicazionevera.retrofit.Utente;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventoDettagliato extends FragmentActivity {

    private GoogleMap mMap;
    ImageView exit;
    int id;
    int statusCode;
    Event evento;
    TextView titolo,luogo,ora,data,descrizione, user;
    Utente use;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_evento_dettagliato);
        id = getIntent().getExtras().getInt("id");
        CercaEvento();
        autore();

        titolo = findViewById(R.id.titolo);
        luogo = findViewById(R.id.luogo);
        ora = findViewById(R.id.ora);
        data = findViewById(R.id.data);
        descrizione= findViewById(R.id.descrizione);
        user= findViewById(R.id.utente);

        MaterialButton butt;
        FloatingActionButton bottone;
        bottone = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        bottone.setOnClickListener(view -> openSezioneComm());


        butt = (MaterialButton) findViewById(R.id.calendar);
        butt.setOnClickListener(new View.OnClickListener() {
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

        exit= (ImageView) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EventoDettagliato.this,Home.class);
                startActivity(intent);
            }
        });


    }

    private void openSezioneComm() {
        Intent intent = new Intent(this, SezioneCommenti.class);
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
    public void openCalendario() {
        Intent intent = new Intent(this, Calendario.class);
        startActivity(intent);
    }
    public void CercaEvento() {
        MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
        Call <Event> call = apiService.getEventByid(id);
        call.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                statusCode = response.code();
                evento=response.body();
                titolo.setText(evento.getNome_evento());
                luogo.setText(evento.getLuogo());
                data.setText(evento.getData());
                descrizione.setText(evento.getDescrizione());
                ora.setText(evento.getOraInizio());
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
            }
        });
    }

    public void autore() {
        MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
        Call <Utente> call = apiService.getAutore(id);
        call.enqueue(new Callback<Utente>() {
            @Override
            public void onResponse(Call<Utente> call, Response<Utente> response) {
                statusCode = response.code();
                use=response.body();
                user.setText(use.getNome()+" "+use.getCognome());
            }

            @Override
            public void onFailure(Call<Utente> call, Throwable t) {
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