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
import com.example.productlist.model.User
import com.google.gson.JsonElement
import kotlinx.android.synthetic.main.register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR)
        getActionBar()?.hide()
        setContentView(R.layout.register)

        Logo.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_register.setOnClickListener{

            var status: String
            var email:String = et_email.text.toString().trim()
            var password:String = et_password.text.toString().trim()
            var conpassword: String = et_confpassword.text.toString().trim()
            if (email.isEmpty() || password.isEmpty() || conpassword.isEmpty() || password!=conpassword){
                if (email.isEmpty()){
                    et_email.error = "Please enter your email"
                    et_email.requestFocus()
                    return@setOnClickListener
                }
                if (password.isEmpty()){
                    et_password.error = "Please enter your password"
                    et_password.requestFocus()
                    return@setOnClickListener
                }
                if (conpassword.isEmpty()){
                    et_confpassword.error = "Please enter your password"
                    et_confpassword.requestFocus()
                    return@setOnClickListener
                }
                if(password!=conpassword){
                    et_password.error = "The password doesn't match!"
                    et_confpassword.error = "The password doesn't match!"
                    et_password.requestFocus()
                    et_confpassword.requestFocus()
                    return@setOnClickListener
                }
            }


            val api = RetrofitClient.retrofit.create(ApiService::class.java)

            var user = User(email, password)

            api.register(user)
                .enqueue(object : Callback<JsonElement> {
                    override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                        d("hi","ok")
                        Toast.makeText(this@RegisterActivity,"you have been registred Successfully", Toast.LENGTH_LONG).show()

                    }
                    override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                        d("hi","ok")
                    }
                })
        }
    }
}