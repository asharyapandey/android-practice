package com.asharya.kotlinapp

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*

class CalenderActivity : AppCompatActivity() {

    private lateinit var tvJoin: TextView
    private lateinit var tvDob: TextView
    private lateinit var etJoin: EditText
    private lateinit var etDob: EditText
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)
        etJoin = findViewById(R.id.etJoin)
        etDob = findViewById(R.id.etDob)
        tvJoin = findViewById(R.id.tvJoin)
        tvDob = findViewById(R.id.tvDob)

        etDob.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                loadCalenderDob()
        }

        etJoin.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                loadCalenderJoin()
        }
    }

    private fun loadCalenderDob() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, yourYear, monthOfYear, dayOfMonth ->
                val age = getAge(yourYear, monthOfYear, dayOfMonth)
                tvDob.text = "Your age is: $age"
            },
            year - 20,
            month,
            day
        )
        datePickerDialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun loadCalenderJoin() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, yourYear, monthOfYear, dayOfMonth ->
                val time = getTime(yourYear, monthOfYear, dayOfMonth)
                tvJoin.text = "It has been $time. Since you Joined."
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getTime(year: Int, month: Int, day: Int): String {
        val c = Calendar.getInstance()
        val year1 = c.get(Calendar.YEAR)
        val month1 = c.get(Calendar.MONTH)
        val day1 = c.get(Calendar.DAY_OF_MONTH)

        val start = LocalDate.of(year, month, day)
        val end = LocalDate.of(year1, month1, day1)

        val days = ChronoUnit.DAYS.between(start, end)

        var months = days / 30
        var years = months/12
        months %= 12
        return if (year == 0 ) "$months months" else "$years years and $months months"

    }

    private fun getAge(year: Int, month: Int, day: Int): String {
        var dob = Calendar.getInstance()
        var today = Calendar.getInstance()

        dob.set(year, month, day)

        var age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) age--

        return age.toString()
    }
}