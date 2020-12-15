package com.asharya.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class AlertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)

        val btnShowDialog : Button = findViewById(R.id.btnShowDialog)

        btnShowDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("My Alert")

            builder.setMessage("Are you sure???")

            builder.setIcon(android.R.drawable.ic_dialog_alert)

            builder.setPositiveButton("Yes") { dialogInterface, which ->
                Toast.makeText(this, "Clicked Yes", Toast.LENGTH_SHORT).show()
            }

            builder.setNeutralButton("Cancel") {dialogInterface, which ->
                Toast.makeText(this, "clicked cancel", Toast.LENGTH_SHORT).show()
            }

            builder.setNegativeButton("No") {dialogInterface, which ->
                Toast.makeText(this, "clicked No", Toast.LENGTH_SHORT).show()
            }

            val alertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }
}