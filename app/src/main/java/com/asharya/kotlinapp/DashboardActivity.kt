package com.asharya.kotlinapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class DashboardActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        val btnListView : Button = findViewById(R.id.btnListView)
        val btnCalender : Button = findViewById(R.id.btnCaldender)
        val btnCountry : Button = findViewById(R.id.btnCountry)

        btnCalender.setOnClickListener(this)
        btnListView.setOnClickListener(this)
        btnCountry.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when(v?.id) {
           R.id.btnListView -> {
               Intent(this, ListViewActivity::class.java).apply {
                   startActivity(this)
               }
           }
           R.id.btnCaldender -> {
               Intent(this, CalenderActivity::class.java).apply {
                   startActivity(this)
               }
           }
           R.id.btnCountry -> {
               Intent(this, CountryActivity::class.java).apply {
                   startActivity(this)
               }
           }
       }
    }
}