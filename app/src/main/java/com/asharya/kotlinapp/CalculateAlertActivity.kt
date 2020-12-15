package com.asharya.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text

class CalculateAlertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_alert)

        val btnCalculate : Button = findViewById(R.id.btnCalculateAlert)
        val etOne : EditText = findViewById(R.id.etNumberOne)
        val etTwo : EditText = findViewById(R.id.etNumberTwo)
        val tvResult : TextView = findViewById(R.id.tvShowAdded)

        btnCalculate.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Add Numbers")
            builder.setMessage("Are you sure you want to add these numbers")

            builder.setIcon(android.R.drawable.ic_dialog_alert)

            builder.setPositiveButton("Yes") {_, _ ->
                val result = etOne.text.toString().toInt() + etTwo.text.toString().toInt()

                tvResult.text = result.toString()
            }

            builder.setNegativeButton("No") { _, _ ->

                tvResult.text = 0.toString()
            }


            val alertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }
}