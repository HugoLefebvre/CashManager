package com.example.productlist.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log.d
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productlist.R
import com.example.productlist.api.ApiService
import com.example.productlist.api.CartAdapter
import com.example.productlist.api.RetrofitClient
import com.example.productlist.model.Article
import kotlinx.android.synthetic.main.activity_row.*
import kotlinx.android.synthetic.main.cart_row.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_main.recyclerView
import kotlinx.android.synthetic.main.content_row.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR)
        getActionBar()?.hide()
        setContentView(R.layout.activity_row)

        val idUser = intent.getIntExtra("idUser", 5)
        System.out.println(idUser)
        val api = RetrofitClient.retrofit.create(ApiService::class.java)

        //tv_deleteAllArticle

        tv_goPay.setOnClickListener {
            val intent = Intent(this@CartActivity, BillActivity::class.java)
            startActivity(intent)
        }

        api.gettotal(idUser)
            .enqueue(object : Callback<Int> {
                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    d("onResponse", "onResponse ${response.body()}")
                    btn_bill.text = "Total: $" + response.body().toString() + ",00"
                }

                override fun onFailure(call: Call<Int>, t: Throwable) {
                    d("onFailure", "ERROR: ${t.message}")
                }
            })

        api.getArticle(idUser)
            .enqueue(object : Callback<List<Article>> {
                override fun onResponse(
                    call: Call<List<Article>>,
                    response: Response<List<Article>>
                ) {
                    d("basma", "onResponse ${response.body()!![0].name}")
                    showData(response.body()!!)
                }
                override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                    d("basma", "onFailure")
                }
            })

    }

    fun showData(articles: List<Article>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@CartActivity)
            adapter = CartAdapter(articles)
        }
    }


}
