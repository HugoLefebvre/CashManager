package com.example.productlist

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.register.*

class RegisterActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR)
        getActionBar()?.hide()
        setContentView(R.layout.register)



        var status : String
        btn_register.setOnClickListener{
            if(et_confpassword.length()>0
                &&et_password.length()>0
                &&et_name.length()>0
                &&et_confpassword.text.toString().equals(et_password.text.toString())) {
                status = "everything is perfect"
                val intent = Intent(this, ProductActivity::class.java)
                startActivity(intent)
            }
            else
                status = "Wrong shit !"
            Toast.makeText(this,status, Toast.LENGTH_SHORT).show()
        }

    }


}