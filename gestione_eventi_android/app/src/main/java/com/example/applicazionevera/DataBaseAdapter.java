/*package com.example.applicazionevera;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseAdapter {

    @SuppressWarnings("unused")
    private static final String LOG_TAG = DataBaseAdapter.class.getSimpleName();
    private Context context;
    private SQLiteDatabase database;
    private DataBaseHelper dbHelper;

    String DATABASE_TABLE = "categorie";
    private static final String KEY_Categoria = "_Categoria";
    private static final String KEY_immagine = "immagine";

    String DATABASE_TABLE2 = "commento";
    private static final String KEY_codice = "_codice";
    private static final String KEY_oggetto_commento = "oggetto_commento";
    private static final String KEY_testo_commento = "testo_commento";
    private static final String KEY_ID_utente = "_ID_utente";

    String DATABASE_TABLE3 = "evento";
    private static final String KEY_numero_evento = "_numero_evento";
    private static final String KEY_Categoria_evento = "Categoria_evento";
    private static final String KEY_nome_evento = "nome_evento";
    private static final String KEY_Descrizione = "Descrizione";
    private static final String KEY_valutazione = "valutazione";
    private static final String KEY_luogo = "luogo";
    private static final String KEY_data = "data";
    private static final String KEY_ora_inizio = "ora_inizio";
    private static final String KEY_ora_fine = "ora_fine";
    private static final String KEY_immagine_evento = "immagine_evento";
    private static final String KEY_ID_posto = "_ID_posto";

    String DATABASE_TABLE4 = "evento_utente";
    private static final String KEY_ID_utente_evento_utente = "_ID_utente_evento_utente";
    private static final String KEY_numero_evento_evento_utente = "_numero_evento_evento_utente";

    String DATABASE_TABLE5 = "luogo";
    private static final String KEY_ID_posto_luogo = "_ID_posto_luogo";
    private static final String KEY_longitudine = "longitudine";
    private static final String KEY_latitudine = "latitudine";

    String DATABASE_TABLE6 = "notifiche";
    private static final String KEY_ID_notifica = "_ID_notifica";
    private static final String KEY_oggetto_notifica = "oggetto_notifica";
    private static final String KEY_testo = "testo";
    private static final String KEY_data_notifiche = "data_notifiche";
    private static final String KEY_ID_utente_notifiche = "_ID_utente_notifiche";

    String DATABASE_TABLE7 = "ticket";
    private static final String KEY_codice_ticket = "_codice_ticket";
    private static final String KEY_oggetto_ticket = "oggetto_ticket";
    private static final String KEY_testo_ticket = "testo_ticket";
    private static final String KEY_ID_utente_ticket = "_ID_utente_ticket";

    private ContentValues createticketValues(String oggetto_ticket, String testo_ticket, int _ID_utente_ticket) {
        ContentValues values = new ContentValues();
        values.put( KEY_oggetto_ticket, oggetto_ticket);
        values.put( KEY_testo_ticket , testo_ticket );
        values.put( KEY_ID_utente_ticket , _ID_utente_ticket );
        return values;
    }
    public long createContact (String oggetto_ticket, String testo_ticket, int _ID_utente_ticket) {
        ContentValues initialValues = createticketValues(oggetto_ticket , testo_ticket , _ID_utente_ticket);
        return database.insertOrThrow(DATABASE_TABLE7, null, initialValues);
    }
    public boolean updateContact (String oggetto_ticket, String testo_ticket, int _ID_utente_ticket) {
        ContentValues updateValues = createticketValues(oggetto_ticket , testo_ticket , _ID_utente_ticket);
        return database.update(DATABASE_TABLE7, updateValues, KEY_codice_ticket + "=" + _ID_utente_ticket,
                null) > 0;
    }
    public boolean deleteContact(String _codice_ticket) {
        return database.delete(DATABASE_TABLE7, KEY_codice_ticket + "=" + _codice_ticket, null) > 0;
    }
    public Cursor fetchAllContacts() {
        return database.query(DATABASE_TABLE7, new String[] { KEY_codice_ticket , KEY_oggetto_ticket , KEY_testo_ticket , KEY_ID_utente_ticket}
                , null, null, null, null, null);
    }

    String DATABASE_TABLE8 = "utente";
    private static final String KEY_ID_utente_utente = "_ID_utente_utente";
    private static final String KEY_nome = "nome";
    private static final String KEY_cognome = "cognome";
    private static final String KEY_username = "username";
    private static final String KEY_eta = "eta";
    private static final String KEY_email = "email";
    private static final String KEY_password = "password";
    private static final String KEY_foto_profilo = "foto_profilo";

    private ContentValues createUtenteValues(String nome, String cognome, Integer eta, String username, String password, String email, String foto_profilo) {
        ContentValues values = new ContentValues();
        values.put( KEY_nome, nome );
        values.put( KEY_cognome , cognome );
        values.put( KEY_eta , eta );
        values.put( KEY_username, username);
        values.put( KEY_email , email );
        values.put( KEY_password, password);
        values.put( KEY_foto_profilo, foto_profilo);
        return values;
    }
    public long createContact (String nome, String cognome, Integer eta, String username, String password, String email, String foto_profilo) {
        ContentValues initialValues = createUtenteValues(nome, cognome, eta, username, password, email, foto_profilo);
        return database.insertOrThrow(DATABASE_TABLE8, null, initialValues);
    }
    public boolean updateContact( int _ID_utente_utente, String nome, String cognome, Integer eta, String username, String password, String email, String foto_profilo){
        ContentValues updateValues = createUtenteValues(nome, cognome, eta, username, password, email, foto_profilo);
        return database.update(DATABASE_TABLE8, updateValues, KEY_ID_utente_utente + "=" + _ID_utente_utente,
                null) > 0;
    }
    public boolean deleteContact(int _ID_utente_utente) {
        return database.delete(DATABASE_TABLE8, KEY_ID_utente_utente + "=" + _ID_utente_utente, null) > 0;
    }
    public Cursor fetchAllContacts() {
        return database.query(DATABASE_TABLE8, new String[] { KEY_ID_utente_utente, KEY_nome, KEY_cognome,
                KEY_username, KEY_eta, KEY_email, KEY_password, KEY_foto_profilo}, null, null, null, null, null);
    }


    public DataBaseAdapter(Context context) {
        this.context = context;
    }

    public DataBaseAdapter open() throws SQLException {
        dbHelper = new DataBaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }
}

*/
