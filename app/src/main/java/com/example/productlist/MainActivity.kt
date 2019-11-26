package com.example.productlist

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.login)

/*
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(ApiService::class.java)

        api.fetchAllProduct().enqueue(object : Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                //d("basma","onResponse: ${response.body()!![0].name}")
                showData(response.body()!!)
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                d("basma","onFailure")

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

    private fun showData(products: List<Product>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ProductAdapter(products)
        }

*/


        var status : String
        login_btn.setOnClickListener {
            if(et_password.text.toString().equals("admin")&& et_email.text.toString().equals("admin")) {
                status = "logged in succesfulyy"
                val intent = Intent(this, ProductActivity::class.java)
                startActivity(intent)
            }else
                status = "fail"
            Toast.makeText(this,status, Toast.LENGTH_SHORT).show()
        }

        tvRegister.setOnClickListener(View.OnClickListener {
            val i = Intent(
                this@MainActivity,
                RegisterActivity::class.java
            )
            startActivity(i)
        })


    }

}
