package com.asharya.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class RadioButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)


        val btnCalculate : Button = findViewById(R.id.btnCalculate)
        val etOne: EditText = findViewById(R.id.etOne)
        val etTwo : EditText = findViewById(R.id.etTwo)
        val rbOptions : RadioGroup = findViewById(R.id.rgOptions)
        val tvResult : TextView = findViewById(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val numOne = etOne.text.toString().toInt()
            val numTwo = etTwo.text.toString().toInt()
            val checkRbId = rbOptions.checkedRadioButtonId
            val option = findViewById<RadioButton>(checkRbId)

            val result = if (option.text == "Sum") numOne + numTwo else numOne - numTwo

            tvResult.text = result.toString()
            Toast.makeText(this, "Sum is $result", Toast.LENGTH_SHORT).show()
        }
    }
}