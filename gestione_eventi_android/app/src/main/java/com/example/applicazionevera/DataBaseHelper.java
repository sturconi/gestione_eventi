package com.example.applicazionevera;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="DataBaseApp.db";
    private static final int DATABASE_VERSION=1;

    private static final String DATABASE_CREATE5 ="create table luogo (_ID_posto integer primary key NOT NULL," +
            "Longitudine PRECISION  NOT NULL," +
            "Latitudine PRECISION NOT NULL);";


    private static final String DATABASE_CREATE="create table categorie (_Categoria VARCHAR(50) primary key NOT NULL," +
            "immagine VARCHAR(1000) NOT NULL);";

    private static final String DATABASE_CREATE3="create table evento (_numero_evento integer primary key autoincrement NOT NULL," +
            "Categoria VARCHAR(50) NOT NULL," +
            "nome_evento VARCHAR(50) NOT NULL," +
            "Descrizione VARCHAR(200)," +
            "valutazione INT," +
            "luogo VARCHAR(50)," +
            "data DATE," +
            "ora_inizio TIME,"+
            "ora_fine TIME,"+
            "immagine VARCHAR(1000),"+
            "_ID_posto INT NOT NULL);";

    private static final String DATABASE_CREATE8="CREATE TABLE utente (_ID_utente INT PRIMARY KEY AUTOINCREMENT NOT NULL,"+
            "nome VARCHAR(50) NOT NULL,"+
            "cognome VARCHAR(50) NOT NULL,"+
            "username VARCHAR(50) NOT NULL,"+
            "eta INT NOT NULL,"+
            "email VARCHAR(50) NOT NULL,"+
            "password VARCHAR(50) NOT NULL,"+
            "foto_profilo VARCHAR(100));";

    private static final String DATABASE_CREATE6="CREATE TABLE notifiche (_Id_notifica INT PRIMARY KEY AUTOINCREMENT NOT NULL,"+
            "oggetto_notifica VARCHAR(50) NOT NULL,"+
            "testo VARCHAR(1000),"+
            "data DATETIME NOT NULL,"+
            "_ID_utente INT NOT NULL);";

    private static final String DATABASE_CREATE4="CREATE TABLE evento_utente (_ID_utente INT NOT NULL," +
            "_numero_evento INT NOT NULL,"+
            "PRIMARY KEY (_ID_utente, _numero_evento));";




    private static final String DATABASE_CREATE7="CREATE TABLE ticket (_codice INT PRIMARY KEY AUTOINCREMENT NOT NULL,"+
            "oggetto_ticket VARCHAR(50) NOT NULL,"+
            "testo_ticket VARCHAR(1000),"+
            "_ID_utente INT NOT NULL);";

    private static final String DATABASE_CREATE2="CREATE TABLE commento (_codice INT PRIMARY KEY AUTOINCREMENT NOT NULL,"+
            "oggetto_commento VARCHAR(50) NOT NULL,"+
            "testo_commento VARCHAR(1000),"+
            "_ID_utente INT NOT NULL);";





    public DataBaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE5);
        database.execSQL(DATABASE_CREATE);
        database.execSQL(DATABASE_CREATE3);
        database.execSQL(DATABASE_CREATE2);
        database.execSQL(DATABASE_CREATE4);
        database.execSQL(DATABASE_CREATE6);
        database.execSQL(DATABASE_CREATE7);
        database.execSQL(DATABASE_CREATE8);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        database.execSQL("DROP TABLE IF EXISTS categoria");
        database.execSQL("DROP TABLE IF EXISTS luogo");
        database.execSQL("DROP TABLE IF EXISTS commento");
        database.execSQL("DROP TABLE IF EXISTS evento");
        database.execSQL("DROP TABLE IF EXISTS evento_utente");
        database.execSQL("DROP TABLE IF EXISTS notifche");
        database.execSQL("DROP TABLE IF EXISTS ticket");
        database.execSQL("DROP TABLE IF EXISTS utente");
        onCreate(database);
    }
}
