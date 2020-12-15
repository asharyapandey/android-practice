package com.asharya.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class AutoCompleteActivity : AppCompatActivity() {

    private val languages = listOf("English","Nepali")
    private lateinit var autoCompleteTextView: AutoCompleteTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_complete)

        autoCompleteTextView = findViewById(R.id.autoComplete)
        val autoCompleteAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            languages
        )

        autoCompleteTextView.setAdapter(autoCompleteAdapter)
        autoCompleteTextView.threshold = 1
    }
}