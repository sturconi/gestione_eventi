package com.example.applicazionevera.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegistrazioneInterface {
    String REGIURL =  "http://localhost/mysql/AppEventi/";
    @FormUrlEncoded
    @POST("registrazione.php")
    Call<String> getUserRegi(
            @Field("nome") String nome,
            @Field("cognome") String cognome,
            @Field("username") String uname,
            @Field("data_nascita") String data_nascita,
            @Field("email") String email,
            @Field("password") String password
    );

}
