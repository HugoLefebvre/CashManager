package com.example.productlist.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log.d
import android.view.Window
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.productlist.R
import com.example.productlist.api.ApiService
import com.example.productlist.api.RetrofitClient
import com.example.productlist.model.Cart
import com.google.gson.JsonElement
import kotlinx.android.synthetic.main.details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


class DetailsActivity: AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR)
        getActionBar()?.hide()
        setContentView(R.layout.details)


       Logo.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            startActivity(intent)
        }

        btn_cart.setOnClickListener{
            val idUser : Int = intent.getIntExtra("idUser",1)
            val intent = Intent(this, CartActivity::class.java)
            intent.putExtra("idUser", idUser)
            d("from Details to Cart","$idUser")
            startActivity(intent)
        }



        btn_addCart.setOnClickListener {

            val idUser : Int = intent.getIntExtra("idUser",1)
            val idArticle : Int = intent.getIntExtra("id",1)

            val api = RetrofitClient.retrofit.create(ApiService::class.java)
            val cart = Cart(1,idUser,idArticle)
            api.addArticle(cart)
                .enqueue(object : Callback<Cart>{
                    override fun onResponse(call: Call<Cart>, response: Response<Cart>) {
                        d("test","onResponce  Cart ID: ${response.body()?.id} User ID: ${response.body()?.idUser}  Article ID: ${response.body()?.idArticle}")
                        Toast.makeText(this@DetailsActivity, "The article has been added to ur cart", Toast.LENGTH_SHORT).show()

                    }

                    override fun onFailure(call: Call<Cart>, t: Throwable) {
                        d("test","onFailure")
                    }
                })

        }
        btn_deleteCart.setOnClickListener {

            val retrofit = Retrofit.Builder()
                .baseUrl("http://172.17.0.1:8080/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()

            val idUser : Int = intent.getIntExtra("idUser",1)
            val idArticle : Int = intent.getIntExtra("id",1)

            val api = retrofit.create(ApiService::class.java)
            api.deleteArticleUser(idUser,idArticle)
                .enqueue(object : Callback<String>{
                    override fun onResponse(call: Call<String>, response: Response<String>){
                        d("hellloooooo","Nickel ${response.body().toString()}")
                    }
                    override fun onFailure(call: Call<String>, t: Throwable) {
                        d("NOOOO","sldfjld ${t.message}")
                    }
                })
        }


        val iduser : Int = intent.getIntExtra("idUser",100)
        System.out.println("aloooors  from Details "+iduser)

        val id : Int = intent.getIntExtra("id",1)
        //article_code.text = id.toString()

        val price : Int = intent.getIntExtra("price",1)
        article_price.text = price.toString()

        val code : String = intent.getStringExtra("code")
        article_code.text = code.toString()

        val name : String = intent.getStringExtra("name")
        article_name.text = name


        btn_deleteArticle.setOnClickListener{
            val api = RetrofitClient.retrofit.create(ApiService::class.java)
            api.deleteArticle(id)
                .enqueue(object : Callback<JsonElement>{
                    override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                        d("The code","OnResponse")
                        val intent = Intent(this@DetailsActivity, ArticleActivity::class.java)
                        startActivity(intent)
                    }
                    override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                        d("The code  ${id}","OnFailure ${t.cause}")

                        val intent = Intent(this@DetailsActivity, ArticleActivity::class.java)
                        startActivity(intent)
                    }
                })
        }
        }
    }
