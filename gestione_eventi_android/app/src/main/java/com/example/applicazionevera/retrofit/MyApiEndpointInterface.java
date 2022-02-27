package com.example.applicazionevera.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyApiEndpointInterface {

    @GET("/utente/{username}")
    Call<Utente> getUser(@Path("username") String username);

    @GET("/utenti")
    Call<List<Utente>> groupList(@Query("sort") String sort);

    @POST("/utenti")
    Call<Utente> createUser(@Body Utente user);

    @POST("/eventi")
    Call<Event> createEvent(@Body Event eve);

    @GET("/eventi/{categoria}")
    Call<List<Event>> getEventBycat(@Path("categoria") String categoria);

}