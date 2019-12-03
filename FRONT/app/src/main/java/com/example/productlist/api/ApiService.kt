package com.example.productlist.api

import com.example.productlist.model.Article
import com.example.productlist.model.Cart
import com.example.productlist.model.User
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    //ARTICLE

    //Get all the Article
    @GET("article/all/")
    fun fetchAllArticle(): Call<List<Article>>

    //Get Article By ID
    @GET("article/id/{id}/")
    fun getArticleId(): Call<Article>

    //Get Article By code
    @GET("article/code/{code}/")
    fun getArticleCode(): Call<Article>

    // add new Article
    @POST("article/")
    fun createArticle(@Body article: Article): Call<Article>

    // Delete Article
    @DELETE("article/{id}")
    fun deleteArticle(@Path("id")id: Int):Call<JsonElement>

    //Change Article information
    @PUT("/article/{id}")
    fun modifyArticle(@Path("id")id: Int,@Body article: Article ): Call<Article>


    //USER
    //Register
    @POST("/register/")
    fun register(@Body user: User): Call<JsonElement>

    @POST("/login/")
    fun login(@Body user: User): Call<JsonElement>

    //CART

    //GET

    //GET all the articles in the user’s cart
    @GET("/cart/user/{id}")
    fun getArticle(@Path("id")id : Int): Call<List<Article>>

    //GET the total price of the user’s cart
    @GET("/cart/user/{id}/total/")
    fun gettotal(@Path("id")id : Int): Call<Int>

    //POST

    //Add new article in a user’s cart
    @POST("/cart/")
    fun addArticle(@Body cart: Cart): Call<Cart>

    //DELETE

    // Delete all articles in the user’s cart
    @DELETE("/cart/user/{id}")
    fun deleteArticles(@Path("id")id: Int) :Call<JsonElement>

    //Cart/user/{id of the user}/article/{id of the article}
    //Delete article with given id in the user’s cart
    @DELETE("/cart/user/{idUser}/article/{idArticle}")
    fun deleteArticleUser(@Path("idUser")idUser : Int,
                          @Path("idArticle")idProduct : Int
                        ):Call<String>





}