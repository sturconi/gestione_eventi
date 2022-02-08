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

        @SerializedName("nome")
        public String name;
        @SerializedName("cognome")
        public String surname;
        public Utente(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }
    }
