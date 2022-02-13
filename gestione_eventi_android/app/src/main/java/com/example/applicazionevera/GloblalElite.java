package com.example.applicazionevera;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class GloblalElite extends Application {
   private boolean switchButton;
   private final static String salva = "textdata";
    private final static String notifica="notifica";
    public GloblalElite(){}
    @Override
    public void onCreate() {

        super.onCreate();
        update();

    }
    public boolean getSwitchButton(){
        return switchButton;
    }
    public void setSwitchButton(){
        if (switchButton==true){
            switchButton=false;
        }
        else{
            switchButton=true;
        }
        save();
    }
    public void save() {
        SharedPreferences Switch = getSharedPreferences(notifica, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Switch.edit();

        //String textData= Boolean.toString(switchButton);
        editor.putBoolean(salva, switchButton);
        editor.commit();

        update();
    }

    private void update(){
        SharedPreferences Switch = getSharedPreferences(notifica, Context.MODE_PRIVATE);
        switchButton= Switch.getBoolean(salva, false);
    }
}
