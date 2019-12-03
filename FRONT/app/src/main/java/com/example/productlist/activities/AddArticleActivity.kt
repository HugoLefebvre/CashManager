package com.example.productlist.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log.d
import android.view.Window
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.productlist.api.ApiService
import com.example.productlist.R
import com.example.productlist.api.RetrofitClient
import com.example.productlist.model.Article
import kotlinx.android.synthetic.main.addarticle.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddArticleActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR)
        getActionBar()?.hide()
        setContentView(R.layout.addarticle)


        btn_add.setOnClickListener{


            val code = et_code.text.toString().trim()
            val name = et_name.text.toString().trim()
            val price:Int = et_price.text.toString().toInt()

            if (code.isEmpty()){
                et_code.error = "Product Code required"
                et_code.requestFocus()
                return@setOnClickListener
            }
            if (name.isEmpty()){
                et_name.error = "Name required"
                et_name.requestFocus()
                return@setOnClickListener
            }
            if (price<0){
                et_price.error = "Price required"
                et_price.requestFocus()
                return@setOnClickListener
            }

            val api = RetrofitClient.retrofit.create(ApiService::class.java)
            var article = Article(35,code,name, price)
            api.createArticle(article)
                .enqueue(object : Callback<Article>{
                    override fun onResponse(call: Call<Article>, response: Response<Article>) {
                        d("the code","onResponse ${response.body()}")
                        Toast.makeText(this@AddArticleActivity,"the Product has been added Successfully!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this@AddArticleActivity, ArticleActivity::class.java)
                        startActivity(intent)

                    }
                    override fun onFailure(call: Call<Article>, t: Throwable) {
                        d("The code","onFailure ${t.cause}")
                    }
                })
        }

    }
}