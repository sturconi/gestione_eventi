package com.example.applicazionevera.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

    public interface LoginInterface {

        String LOGINURL = "http://localhost/mysql/AppEventi/";
        @FormUrlEncoded
        @POST("login.php")
        Call<String> getUserLogin(

                @Field("username") String uname,
                @Field("password") String password
        );
    }

