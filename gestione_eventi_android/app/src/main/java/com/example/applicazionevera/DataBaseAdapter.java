package com.example.applicazionevera;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseAdapter {

    @SuppressWarnings("unused")
    private static final String LOG_TAG = DataBaseAdapter.class.getSimpleName();
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;


    String DATABASE_TABLE = "categorie";
    private static final String KEY_Categoria = "Categoria";
    private static final String KEY_immagine = "immagine";

    String DATABASE_TABLE2 = "commento";
    private static final String KEY_codice = "codice";
    private static final String KEY_oggetto_commento = "oggetto_commento";
    private static final String KEY_testo_commento = "testo_commento";
    private static final String KEY_ID_utente = "ID_utente";

    String DATABASE_TABLE3 = "evento";
    private static final String KEY_numero_evento = "numero_evento";
    private static final String KEY_Categoria_evento = "Categoria_evento";
    private static final String KEY_nome_evento = "nome_evento";
    private static final String KEY_Descrizione = "Descrizione";
    private static final String KEY_valutazione = "valutazione";
    private static final String KEY_luogo = "luogo";
    private static final String KEY_data = "data";
    private static final String KEY_ora_inizio = "ora_inizio";
    private static final String KEY_ora_fine = "ora_fine";
    private static final String KEY_immagine_evento = "immagine_evento";
    private static final String KEY_ID_posto = "ID_posto";

    String DATABASE_TABLE4 = "evento_utente";
    private static final String KEY_ID_utente_evento_utente = "ID_utente_evento_utente";
    private static final String KEY_numero_evento_evento_utente = "numero_evento_evento_utente";

    String DATABASE_TABLE5 = "luogo";
    private static final String KEY_ID_posto_luogo = "ID_posto_luogo";
    private static final String KEY_longitudine = "longitudine";
    private static final String KEY_latitudine = "latitudine";

    String DATABASE_TABLE6 = "notifiche";
    private static final String KEY_ID_notifica = "ID_posto_luogo";
    private static final String KEY_oggetto_notifica= "longitudine";
    private static final String KEY_testo = "latitudine";
    private static final String KEY_data_notifiche = "longitudine";
    private static final String KEY_ID_utente_notifiche = "latitudine";

    String DATABASE_TABLE7 = "ticket";
    private static final String KEY_codice_ticket = "codice_ticket";
    private static final String KEY_oggetto_ticket = "oggetto_ticket";
    private static final String KEY_testo_ticket = "testo_ticket";
    private static final String KEY_ID_utente_ticket = "ID_utente_ticket";

    String DATABASE_TABLE8 = "utente";
    private static final String KEY_ID_utente_utente = "ID_utente_utente";
    private static final String KEY_nome= "nome";
    private static final String KEY_cognome = "cognome";
    private static final String KEY_username = "username";
    private static final String KEY_eta = "eta";
    private static final String KEY_email= "email";
    private static final String KEY_password = "password";
    private static final String KEY_foto_profilo = "foto_profilo";



    public DataBaseAdapter(Context context) {
        this.context = context;
    }

    public DataBaseAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
}
