package com.example.productlist.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log.d
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.productlist.R
import com.example.productlist.api.ApiService
import com.example.productlist.api.RetrofitClient
import com.google.gson.JsonElement
import kotlinx.android.synthetic.main.details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsActivity: AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR)
        getActionBar()?.hide()
        setContentView(R.layout.details)



        val id : Int = intent.getIntExtra("id",1)
        //article_code.text = id.toString()

        val price = intent.getIntExtra("price",1)
        article_price.text = price.toString()

        val code = intent.getStringExtra("code")
        article_code.text = code.toString()

        val name = intent.getStringExtra("name")
        article_name.text = name


        btn_deleteArticle.setOnClickListener{
            val api = RetrofitClient.retrofit.create(ApiService::class.java)
            api.deleteArticle(id)
                .enqueue(object : Callback<JsonElement>{
                    override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                        d("basma","ok")
                        val intent = Intent(this@DetailsActivity, ArticleActivity::class.java)
                        startActivity(intent)
                    }

                    override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                        d("basma  ${id}","non ${t.cause}")

                        val intent = Intent(this@DetailsActivity, ArticleActivity::class.java)
                        startActivity(intent)
                    }

                })
        }
        }
    }
