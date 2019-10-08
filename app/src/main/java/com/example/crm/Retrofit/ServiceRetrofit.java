package com.example.crm.Retrofit;

import com.example.crm.ModelLogin.Login;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceRetrofit {
//    https://crm.phanmemninja.com/api/userapi
    @POST("api/userapi")
    Call<Login> createUser(@Body Login login);
}
