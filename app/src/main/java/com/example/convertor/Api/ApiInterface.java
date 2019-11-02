package com.example.convertor.Api;

import com.example.convertor.Models.Currencies;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    @GET("latest? access_key=18fb5bcdd4e7cd7b8fd0024e5710eebe")
    Call<Currencies> getCurrency();
}
