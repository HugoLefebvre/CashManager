package com.example.productlist.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.productlist.R
import kotlinx.android.synthetic.main.bar.*

class BarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.bar)

        /*Logo.setOnClickListener{
            val intent = Intent(this, ArticleActivity::class.java)
            d("hellooo","ids")
            startActivity(intent)
        }*/
    }

    }