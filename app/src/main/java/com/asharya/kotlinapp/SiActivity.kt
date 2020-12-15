package com.asharya.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class SiActivity : AppCompatActivity() {

    private lateinit var etPrinciple : EditText
    private lateinit var etRate: EditText
    private lateinit var etTime: EditText
    private lateinit var btnCalculate : Button
    private lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_si)


        etPrinciple= findViewById(R.id.etPrinciple)
        etRate= findViewById(R.id.etRate)
        etTime= findViewById(R.id.etTime)
        btnCalculate= findViewById(R.id.btnCalculate)
        tvResult = findViewById(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val principle = etPrinciple.text.toString().toInt()
            val rate= etRate.text.toString().toInt()
            val time = etTime.text.toString().toInt()


            val result = (principle * rate * time ) / 100

            tvResult.text = "Rs. $result"
        }

        val btnRBA : Button = findViewById(R.id.btnRBA)

        btnRBA.setOnClickListener {
            Intent(this, RadioButtonActivity::class.java).also {
                startActivity(it)
            }
        }

        val btnTest : Button = findViewById(R.id.btnTest)

        btnTest.setOnClickListener {
            Intent(this, MessageActivity::class.java).also {
                startActivity(it)
            }
        }

        val btnMain: Button = findViewById(R.id.btnMain)

        btnMain.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
        val btnImage: Button = findViewById(R.id.btnImage)

        btnImage.setOnClickListener {
            Intent(this, ImageActivity::class.java).also {
                startActivity(it)
            }
        }

        val spinner : Spinner = findViewById(R.id.spinner)

        val customList = listOf("Apple", "Mango", "Orange")
        val adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customList)
        spinner.adapter = adapter


    }

    
}