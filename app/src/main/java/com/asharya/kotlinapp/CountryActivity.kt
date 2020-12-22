package com.asharya.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class CountryActivity : AppCompatActivity() {
    private val countries = arrayOf(
        "Nepal", "Kathamandu",
        "India", "New Dheli",
        "China", "Bejing"
    )
    private lateinit var countryList : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        countryList = findViewById(R.id.countryList)

        val countryCapitalMap  = mutableMapOf<String, String>()

        for (i in countries.indices step 2) countryCapitalMap[countries[i]] = countries[i + 1]

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            countryCapitalMap.keys.toTypedArray()
        )
        countryList.adapter = adapter

        countryList.setOnItemClickListener { parent, view, position, id ->
            val e = parent.getItemAtPosition(position).toString()
            val capital = countryCapitalMap[e]
            Intent(this@CountryActivity, CapitalActivity::class.java).also {
                it.putExtra("COUNTRY", e)
                it.putExtra("CAPITAL", capital)
                startActivity(it)

            }
        }

    }
}