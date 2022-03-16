package com.example.applicazionevera.retrofit;

import com.example.applicazionevera.model_and_adapter.ListLocationModel;
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
import retrofit2.http.Query;

public interface MyApiEndpointInterface {

    @GET("/utente/{username}")
    Call<Utente> getUser(@Path("username") String username);

    @GET("/utenti")
    Call<List<Utente>> groupList(@Query("sort") String sort);

    @POST("/utenti")
    Call<Utente> createUser(@Body Utente user);

    @PUT("/utenti/{username}")
    Call<Utente> updatePass(@Path("username")String username);

    @POST("/eventi")
    Call<Event> createEvent(@Body Event eve);

    @GET("/eventi/{categoria}")
    Call<List<Event>> getEventBycat(@Path("categoria") String categoria);

    @GET("/eventi")
    Call<List<Event>> getAllEvent();

    @Multipart
    @POST("/upload")
    Call<ResponseBody> uploadImage(@Part MultipartBody.Part file, @Part("name") RequestBody requestBody);

    @GET("/JsonDisplayMarker")
    Call<ListLocationModel> getAllLocation();
}