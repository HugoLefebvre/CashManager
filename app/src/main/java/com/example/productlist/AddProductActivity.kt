package com.example.productlist

import android.os.Build
import android.os.Bundle
import android.util.Log.d
import android.view.Window
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addproduct.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddProductActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR)
        getActionBar()?.hide()
        setContentView(R.layout.addproduct)
        btn_add.setOnClickListener(){

            val pCode = et_pcode.text.toString().trim()
            val name = et_name.text.toString().trim()
            val prix_unit:Int = et_price.text.length

            if (pCode.isEmpty()){
                et_pcode.error = "Product Code required"
                et_pcode.requestFocus()
                return@setOnClickListener
            }
            if (name.isEmpty()){
                et_name.error = "Name required"
                et_name.requestFocus()
                return@setOnClickListener
            }
            /*if (prix_unit.){
                et_price.error = "Price required"
                et_price.requestFocus()
                return@setOnClickListener
            }*/


            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val api = retrofit.create(ApiService::class.java)

            api.createProduct(pCode,name,prix_unit)
                .enqueue(object :Callback<Product>{
                    override fun onResponse(call: Call<Product>, response: Response<Product>) {
                        Toast.makeText(applicationContext, "GOoood" , Toast.LENGTH_LONG).show()
                          d("basma","onResponse")
                    }

                    override fun onFailure(call: Call<Product>, t: Throwable) {
                        //Toast.makeText(applicationContext, t.toString(), Toast.LENGTH_LONG).show()
                        d("basma","onFailure")

                    }

                })
        }
    }
}