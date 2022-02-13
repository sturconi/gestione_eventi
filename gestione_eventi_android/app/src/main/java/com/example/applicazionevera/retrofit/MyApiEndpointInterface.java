package com.example.applicazionevera.retrofit;

import com.example.applicazionevera.Utente;
import com.google.firebase.firestore.auth.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyApiEndpointInterface {
    //GET http://api.myservice.com/users/francesca
    @GET("/users/{username}")
    Call<Utente> getUser(@Path("username") String username);
    //GET http://www.sito.it/group/103/users?sort=asc
    @GET("/group/{id}/users")
    Call<List<Utente>> groupList(@Path("id") int groupId, @Query("sort") String sort);
    @POST("/users/new")
    Call<Utente> createUser(@Body Utente user);
}