package com.example.applicazionevera.retrofit;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    private final String INTRO = "intro";
    private final String NOME = "nome";
    private final String COGNOME = "cognome";
    private SharedPreferences app_prefs;
    private Context context;

    public PreferenceHelper(Context context) {
        app_prefs = context.getSharedPreferences("shared",
                Context.MODE_PRIVATE);
        this.context = context;
    }

    public void putIsLogin(boolean loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putBoolean(INTRO, loginorout);
        edit.commit();
    }
    public boolean getIsLogin() {
        return app_prefs.getBoolean(INTRO, false);
    }

    public void putNome(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(NOME, loginorout);
        edit.commit();
    }
    public String getNome() {
        return app_prefs.getString(NOME, "");
    }

    public void putCognome(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(COGNOME, loginorout);
        edit.commit();
    }
    public String getCognome() {
        return app_prefs.getString(COGNOME, "");
    }

}
