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
    private final static String notificaSport="notificaSport";
    private final static String notificaCul="notificaCul";
    private final static String notificaInt="notificaInt";
    private final static String notificaServ="notificaServ";
    private final static String REGIURL =  "http://10.0.2.2:8080/";

    Retrofit retrofit = null;
    public GloblalElite(){
        retrofit = new Retrofit.Builder()
                .baseUrl(REGIURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }
    @Override
    public void onCreate() {

        super.onCreate();
        update(switchButtonSport, notificaSport);
        update(switchButtonCul, notificaCul);
        update(switchButtonInt, notificaInt);
        update(switchButtonServ, notificaServ);

    }
    public boolean getSwitchButtonSport(){
        return switchButtonSport;
    }
    public void setSwitchButtonSport(){
        if (switchButtonSport==true){
            switchButtonSport=false;
        }
        else{
            switchButtonSport=true;
        }
        save(switchButtonSport, notificaSport);
    }
    public boolean getSwitchButtonCul(){
        return switchButtonCul;
    }
    public void setSwitchButtonCul() {
        if (switchButtonCul == true) {
            switchButtonCul = false;
        } else {
            switchButtonCul = true;
        }
        save(switchButtonCul, notificaCul);
    }
        public boolean getSwitchButtonInt(){
            return switchButtonInt;
        }
        public void setSwitchButtonInt(){
            if (switchButtonInt==true){
                switchButtonInt=false;
            }
            else{
                switchButtonInt=true;
            }
            save(switchButtonInt, notificaInt);
        }
        public boolean getSwitchButtonServ(){
            return switchButtonServ;
        }
        public void setSwitchButtonServ(){
            if (switchButtonServ==true){
                switchButtonServ=false;
            }
            else{
                switchButtonServ=true;
            }
            save(switchButtonServ, notificaServ);
        }

    public void save(Boolean switchButton, String notifica) {
        SharedPreferences Switch = getSharedPreferences(notifica, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Switch.edit();


        editor.putBoolean(salva, switchButton);
        editor.commit();

        update(switchButton, notifica);
    }

    private void update(Boolean switchButton, String notifica){
        SharedPreferences Switch = getSharedPreferences(notifica, Context.MODE_PRIVATE);
        switchButton= Switch.getBoolean(salva, false);
    }

    @POST("/utenti")
    public Call<Utente> createUser(Utente user) {
        return (Call<Utente>) user;
    }
}
