package com.asharya.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CapitalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capital)

        val tvShowCapital : TextView = findViewById(R.id.tvShowCapital)

        val intent = intent
        if (intent != null ) {
            val country = intent.getStringExtra("COUNTRY")
            val capital = intent.getStringExtra("CAPITAL")

            tvShowCapital.text = "The capital of $country is $capital"
        } else tvShowCapital.text = "No values received"
    }


}