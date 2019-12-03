package com.example.productlist.activities

import android.os.Build
import android.os.Bundle
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.productlist.R
import kotlinx.android.synthetic.main.activity_bill.*

class BillActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR)
        getActionBar()?.hide()
        setContentView(R.layout.activity_bill)

        NFC.setOnClickListener {

        }
        QR.setOnClickListener {

        }

    }
}