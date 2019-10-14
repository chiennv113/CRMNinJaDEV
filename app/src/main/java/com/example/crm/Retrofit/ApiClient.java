package com.example.crm.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
//    public static final String BASE_URL = "https://crm.phanmemninja.com";
//    private static Retrofit retrofit;
//
//    public static Retrofit getClient() {
//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }

    private static ServiceRetrofit instance;

    public static ServiceRetrofit getInstance() {

        if (instance == null) {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://crm.phanmemninja.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            instance = retrofit.create(ServiceRetrofit.class);
        }

        return instance;

    }
}
