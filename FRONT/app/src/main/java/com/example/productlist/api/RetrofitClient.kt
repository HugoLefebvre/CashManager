package com.example.productlist.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("http://172.17.0.1:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}