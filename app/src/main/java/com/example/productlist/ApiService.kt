package com.example.productlist

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("product/all/")
    fun fetchAllProduct(): Call<List<Product>>

    @FormUrlEncoded
    @POST("product/")
    fun createProduct(
        @Field("pCode")pCode:String,
        @Field("name")name:String,
        @Field("prix_unit")prix_unit:Int

    ): Call<Product>


}