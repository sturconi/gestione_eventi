package com.example.applicazionevera.retrofit;

import com.example.applicazionevera.model_and_adapter.ListLocationModel;
import com.example.applicazionevera.model_and_adapter.LocationModel;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface MyApiEndpointInterface {

    @GET("/utente/{username}")
    Call<Utente> getUser(@Path("username") String username);

    @GET("/utenti")
    Call<List<Utente>> geteAll();

    @GET("/username")
    Call<List<Utente>> geteAllusername();

    @POST("/utenti")
    Call<Utente> createUser(@Body Utente user);

    @PUT("/utenti/{username}/{password}")
    Call<Utente> updatePass(@Path("username")String username ,@Path("password")String password);

    @GET("/autore/{numero_evento}")
    Call <Utente> getAutore(@Path("numero_evento") int numero_evento);

    @POST("/eventi")
    Call<Event> createEvent(@Body Event eve);

    @GET("/eventi/{categoria}")
    Call<List<Event>> getEventBycat(@Path("categoria") String categoria);

    @GET("/evento/{numero_evento}")
    Call <Event> getEventByid(@Path("numero_evento") int numero_evento);

    @GET("/eventi")
    Call<List<Event>> getAllEvent();

    @Multipart
    @POST("/upload")
    Call<ResponseBody> uploadImage(@Part MultipartBody.Part file, @Part("name") RequestBody requestBody);

    @GET("/luogo")
    Call<List<LocationModel>> getAllLocation();
}