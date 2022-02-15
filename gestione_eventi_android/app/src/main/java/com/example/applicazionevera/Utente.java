package com.example.applicazionevera;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class Utente {
        public String username;
        public String cognome;
        public String nome;
        public String email;
        public String password;
        public int eta;
        public int ID_utente;


        public Utente(String username, String cognome, String nome, String email, String password, int ID_utente) {
            this.username = username;
            this.cognome = cognome;
            this.nome= nome;
            this.email= email;
            this.password=password;
            this.ID_utente=ID_utente;
        }

    public String getUsername() {
        return username;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getEta() {
        return eta;
    }

    public int getID_utente() {
        return ID_utente;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public void setID_utente(int ID_utente) {
        this.ID_utente = ID_utente;
    }
}
