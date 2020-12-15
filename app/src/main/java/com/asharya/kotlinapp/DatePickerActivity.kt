package com.asharya.kotlinapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class DatePickerActivity : AppCompatActivity() {
    lateinit var tvShowPickedDate : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)

        tvShowPickedDate = findViewById(R.id.tvShowPickedDate)
        val btnShowDatePicker : Button = findViewById(R.id.btnShowDatePicker)

        btnShowDatePicker.setOnClickListener {
            loadCalender()
        }
    }

    private fun loadCalender() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                tvShowPickedDate.text = "Selected Date: $dayOfMonth/${monthOfYear+1}/$year"
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

}