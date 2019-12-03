package com.example.productlist.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.productlist.R
import com.example.productlist.api.ApiService
import com.example.productlist.api.RetrofitClient
import com.example.productlist.model.User
import com.google.gson.JsonElement
import kotlinx.android.synthetic.main.login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.login)


        tvRegister.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        })


        login_btn.setOnClickListener {

            var status: String
            var email: String = et_email.text.toString().trim()
            var password: String = et_password.text.toString().trim()

            if (email.isEmpty()) {
                et_email.error = "Please enter your email"
                et_email.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                et_password.error = "Please enter your password"
                et_password.requestFocus()
                return@setOnClickListener
            }

            val api = RetrofitClient.retrofit.create(ApiService::class.java)

            var user = User(email, password)

            api.login(user)
                .enqueue(object : Callback<JsonElement> {
                    override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                        d("Sorry", "Please check your connection or your Server")
                    }

                    override fun onResponse(
                        call: Call<JsonElement>,
                        response: Response<JsonElement>
                    ) {

                        var je = response.body()
                        if (je == null || !je.isJsonPrimitive) {
                            d(
                                "OOPS",
                                "not permitive OR No element retrieved OR the Email/password isn't correct !)}"
                            )
                            Toast.makeText(this@MainActivity, "FAIL", Toast.LENGTH_SHORT).show()
                            return
                        }
                        if (je.asJsonPrimitive.isNumber) {

                            d("the code", "okay ${je.asJsonPrimitive.asInt}")
                            status = "logged in successfully "
                            val intent = Intent(this@MainActivity, ArticleActivity::class.java)
                            intent.putExtra("idUser", je.asJsonPrimitive.asInt)
                            startActivity(intent)
                            Toast.makeText(this@MainActivity, status, Toast.LENGTH_SHORT).show()

                        } else
                            d("NEVER detected", "mot de passe isn't correct")
                    }
                })
        }
    }
}