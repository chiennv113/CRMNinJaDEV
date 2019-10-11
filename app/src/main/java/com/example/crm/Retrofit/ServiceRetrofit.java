package com.example.crm.Retrofit;

import android.content.Context;
import android.util.Log;

import com.example.crm.Model.CustomerFeel;
import com.example.crm.Model.ModelAdd;
import com.example.crm.Model.ModelLogin.Login;
import com.example.crm.Model.ModelSearchCu.Customer;
import com.example.crm.Model.ModelSearchCu.Search;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServiceRetrofit {
    //    https://crm.phanmemninja.com/api/userapi
    @POST("api/userapi")
    Call<Login> createUser(@Body Login login);

    @POST("api/userapi")
    Call<Search> search(@Query("infocheck") String info,
                        @Query("option") String option,
                        @Header("Cookie") String cookie,
                        @Header("Content-Type") String content);

    //https://crm.phanmemninja.com/api/phoneapi

    @POST("api/phoneapi")
    Call<CustomerFeel> getFeel(@Query("option") String option,
                               @Header("Content-Type") String content);

    @POST("api/phoneapi")
    Call<ModelAdd> add(@Query("option")String option,
                       @Query("customer_id") int customer_id,
                       @Query("content") String content,
                       @Query("customer_feel") String customer_feel,
                       @Header("Cookie") String cookie,
                       @Header("Content-Type") String type);
}
