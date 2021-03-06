package com.example.applicazionevera;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applicazionevera.retrofit.MyApiEndpointInterface;
import com.example.applicazionevera.retrofit.Utente;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    EditText userET = null;
    EditText passwordET = null;
    TextView reg;

    String Lusername = null;
    String Lpassword= null;
    String Lnome=null;
    String Lcognome=null;
    String Lemail=null;
    Utente u= null;
    String usernameControl=null;
    String passwordControl=null;
    int idu;

    private  final  static  String  MY_PREFERENCES  =  "MyPref";
    private  final  static  String  TEXT_LOGIN_KEY  =  "textLogin";
    private  final  static  String  TEXT_PASSWORD_KEY  =  "textPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MaterialButton button;
        userET = findViewById(R.id.username);
        passwordET = findViewById(R.id.password);
        reg = (TextView) findViewById(R.id.registrati);


        button = (MaterialButton) findViewById(R.id.buttonAccedi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Lusername = userET.getText().toString();
                 Lpassword = passwordET.getText().toString();
                 loginMe();
                 savePreferencesData();
            }
        });

       /* if(TEXT_PASSWORD_KEY !=null && TEXT_LOGIN_KEY!=null){
            updatePreferencesData();
            openHome();
        }*/

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegistrazione();
            }
        });
    }
    public void openHome() {
        Intent HomeIntent = new Intent(this, Home.class);
        HomeIntent.putExtra("username", Lusername);
        HomeIntent.putExtra("password", Lpassword);
        HomeIntent.putExtra("nome", Lnome);
        HomeIntent.putExtra("cognome", Lcognome);
        HomeIntent.putExtra("email", Lemail);
        HomeIntent.putExtra("idutente", idu);


        startActivity(HomeIntent);
        finish();

    }
    public void openRegistrazione() {
        Intent intent = new Intent(this, Registrazione.class);
        startActivity(intent);
    }
    public void loginMe() {
        MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
        Call<Utente> call = apiService.getUser(Lusername);
        call.enqueue(new Callback<Utente>() {
            @Override
            public void onResponse(Call<Utente> call, Response<Utente> response) {
                int statusCode = response.code();
                if(statusCode==500){
                    Toast.makeText(Login.this, "Utente inesistente!", Toast.LENGTH_SHORT).show();
                }
                else{
                    u=response.body();
                    usernameControl=u.getUsername();
                    passwordControl=u.getPassword();
                    Lnome=u.getNome();
                    Lcognome=u.getCognome();
                    Lemail=u.getEmail();
                    idu=u.getID_utente();
                    Controllo();
                }

            }
            @Override
            public void onFailure(Call<Utente> call, Throwable t) {
                Toast.makeText(Login.this, "Errore", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Controllo(){

        if(Lusername.equals(usernameControl) && Lpassword.equals(passwordControl)){
            Toast.makeText(Login.this, "Benvenuto "+Lusername+"!", Toast.LENGTH_SHORT).show();
            openHome();
        }
        else{
            Toast.makeText(Login.this, "Username o Password non validi!", Toast.LENGTH_SHORT).show();
        }
    }
    public static final String BASE_URL = "http://10.0.2.2:8080/";
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    public  void  savePreferencesData()  {
        SharedPreferences prefs  =  getSharedPreferences(MY_PREFERENCES,  Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor  =  prefs.edit();
        EditText outputUser  =  (EditText)  findViewById(R.id.username);
        EditText outputPass  =  (EditText)  findViewById(R.id.password);
        CharSequence  textUser  =  outputUser.getText();
        CharSequence  textPass  =  outputPass.getText();
        if  (textUser  !=  null && textPass != null)  {
            editor.putString(TEXT_LOGIN_KEY,  textUser.toString());
            editor.putString(TEXT_PASSWORD_KEY,  textPass.toString());
            editor.commit();
        }
        updatePreferencesData();
    }
    private  void  updatePreferencesData(){
        SharedPreferences  prefs  =  getSharedPreferences(MY_PREFERENCES,  Context.MODE_PRIVATE);
        Lusername  =  prefs.getString(TEXT_LOGIN_KEY,  "");
        Lpassword  =  prefs.getString(TEXT_PASSWORD_KEY,  "");
    }
}