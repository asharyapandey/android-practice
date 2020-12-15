package com.asharya.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalculate: Button
    private lateinit var etOne: EditText
    private lateinit var etTwo: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate = findViewById(R.id.btnCalculate)
        etOne = findViewById(R.id.etOne)
        etTwo = findViewById(R.id.etTwo)
        tvResult = findViewById(R.id.tvResult)

        btnCalculate.setOnClickListener {
            if (validate()) retrieve()
        }
    }

    private fun validate(): Boolean {
        if (TextUtils.isEmpty(etOne.text)) {
            etOne.error = "Please enter the first nubmer."
            etOne.requestFocus()
            return false
        } else if (TextUtils.isEmpty(etTwo.text)) {
            etTwo.error = "Please enter the second Number"
            etTwo.requestFocus()
            return false
        }
        return true
    }

    private fun retrieve() {
        val numOne = etOne.text.toString().toInt()
        val numTwo = etTwo.text.toString().toInt()

        tvResult.text = add(numOne, numTwo).toString()
    }

    private fun add(first: Int, second: Int) = first + second
}