package com.example.applicazionevera;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.applicazionevera.retrofit.Utente;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.POST;

public class GloblalElite extends Application {
    private boolean switchButtonSport;
    private boolean switchButtonInt;
    private boolean switchButtonCul;
    private boolean switchButtonServ;
    private final static String salva = "textdata";
    public final static String notificaSport="notificaSport";
    public final static String notificaCul="notificaCul";
    public final static String notificaInt="notificaInt";
    public final static String notificaServ="notificaServ";
    public final static String REGIURL =  "http://10.0.2.2:8080/";

    Retrofit retrofit = null;
    public GloblalElite(){
        retrofit = new Retrofit.Builder()
                .baseUrl(REGIURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    public void save(Boolean switchButton, String notifica) {
        SharedPreferences Switch = getSharedPreferences(notifica, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Switch.edit();

        editor.putBoolean(notifica, switchButton);
        editor.commit();

//        update(switchButton, notifica);
    }

    public Boolean update(String notifica){
        SharedPreferences Switch = getSharedPreferences(notifica, Context.MODE_PRIVATE);
        return Switch.getBoolean(notifica, false);
    }

    @POST("/utenti")
    public Call<Utente> createUser(Utente user) {
        return (Call<Utente>) user;
    }
}