package com.example.productlist

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log.d
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit.*
import retrofit2.converter.gson.GsonConverterFactory

class ProductActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR)
        getActionBar()?.hide()
        setContentView(R.layout.activity_main)

        tv_addnewproduct.setOnClickListener{
            val intent = Intent(this, AddProductActivity::class.java)
            startActivity(intent)
        }

        val retrofit = Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(ApiService::class.java)

        api.fetchAllProduct()
            .enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                //d("basma","onResponse: ${response.body()!![0].name}")
                showData(response.body()!!)
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                d("basma", "onFailure")
            }
        })
        /*val products = mutableListOf<Product>()
        for(i in 0..1){
            products.add(Product("Basma","Techa",1))
        }
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ProductAdapter(products)
        }*/
    }
    fun showData(products: List<Product>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ProductActivity)
            adapter = ProductAdapter(products)
        }
    }
}