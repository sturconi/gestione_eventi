package com.example.applicazionevera;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applicazionevera.retrofit.MyApiEndpointInterface;
import com.example.applicazionevera.retrofit.Utente;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cambiopassword extends AppCompatActivity {
    Utente u=null;
    int statusCode;
    EditText passwordET = null;
    String passwordControl=null;
    String passwordControl1=null;
    Button button;
    EditText  etPassword, etRepeatPassword;
    String username =  null;
    String password = null ;
    String passwordAttuale=null;
    String nome=null;
    String cognome=null;
    String email=null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiopasswo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username = getIntent().getExtras().getString("username");
        password = getIntent().getExtras().getString("password");
        nome = getIntent().getExtras().getString("nome");
        cognome = getIntent().getExtras().getString("cognome");
        email = getIntent().getExtras().getString("email");
        viewInitializations();

        button = (Button) findViewById(R.id.buttonConfer);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordAttuale=passwordET.getText().toString();
                passwordControl=etPassword.getText().toString();
                passwordControl1=etRepeatPassword.getText().toString();
            Controllo();
            }
        });



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.toSettings);
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
        intent.putExtra("password", passwordControl);
        intent.putExtra("nome", nome);
        intent.putExtra("cognome", cognome);
        intent.putExtra("email", email);
        startActivity(intent);
    }
    public void openAccount() {
        Intent intent = new Intent(this, Account.class);
        intent.putExtra("username", username);
        intent.putExtra("password", passwordControl);
        intent.putExtra("nome", nome);
        intent.putExtra("cognome", cognome);
        intent.putExtra("email", email);
        startActivity(intent);
    }

    void viewInitializations() {
        passwordET = findViewById(R.id.passAttuale);
        etPassword = findViewById(R.id.passNuova);
        etRepeatPassword = findViewById(R.id.passRipetizione);
        // To show back button in actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void Controllo(){

        if(passwordAttuale.equals(password)){
            if(passwordControl.equals(passwordControl1)){
                updatepass();
                Toast.makeText(Cambiopassword.this, "Password cambiata!", Toast.LENGTH_SHORT).show();
                openAccount();
            }
            else{
                Toast.makeText(Cambiopassword.this, "Le password non corrispondono!", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(Cambiopassword.this, "La password attuale errata!", Toast.LENGTH_SHORT).show();
        }
    }



    public void updatepass() {
        MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
        Call<Utente> call = apiService.updatePass(username,passwordControl);
        call.enqueue(new Callback<Utente>() {
            @Override
            public void onResponse(Call<Utente> call, Response<Utente> response) {
                statusCode = response.code();
                u = response.body();
                if(statusCode==500){
                    Toast.makeText(Cambiopassword.this, "Errore", Toast.LENGTH_SHORT).show();
                }
                else{
                    u=response.body();
                }
            }

            @Override
            public void onFailure(Call<Utente> call, Throwable t) {
            }
        });
    }

    public static final String BASE_URL = "http://10.0.2.2:8080/";
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

}

