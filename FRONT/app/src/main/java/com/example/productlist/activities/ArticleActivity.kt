package com.example.productlist.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log.d
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.productlist.api.ArticleAdapter
import com.example.productlist.R
import com.example.productlist.api.ApiService
import com.example.productlist.api.RetrofitClient
import com.example.productlist.model.Article
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_main.Logo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR)
        getActionBar()?.hide()
        setContentView(R.layout.activity_main)

        tv_addnewproduct.setOnClickListener{
            val intent = Intent(this, AddArticleActivity::class.java)
            startActivity(intent)
        }

        val api = RetrofitClient.retrofit.create(ApiService::class.java)

        api.fetchAllArticle()
            .enqueue(object : Callback<List<Article>> {

            override fun onResponse(call: Call<List<Article>>,response: Response<List<Article>>) {
                val i=intent.getIntExtra("idUser",50)
                System.out.println("from main to article activity "+i)
                showData(response.body()!!, i)
            }
            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                d("the code", "onFailure")
            }
            })
    }

    fun showData(articles: List<Article>, i :Int) {
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@ArticleActivity,2)
            adapter = ArticleAdapter(articles,i)

        }


    }



}