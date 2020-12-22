package com.asharya.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ListViewActivity : AppCompatActivity() {
    private lateinit var listView : ListView
    private val countries = arrayOf("Nepal", "India", "China")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listView = findViewById(R.id.listView)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            countries
        )
        listView.adapter = adapter
        
        listView.setOnItemClickListener { parent, view, position, id -> 
            val element = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, element, Toast.LENGTH_SHORT).show()
        }

    }
}