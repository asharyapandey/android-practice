package com.asharya.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup

class ImageActivity : AppCompatActivity() {

    private lateinit var rbSelect : RadioGroup
    private lateinit var imgProfile : ImageView
    private lateinit var rdoDooku : RadioButton
    private lateinit var rdoMaul : RadioButton
    private lateinit var rdoTano : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        rbSelect = findViewById(R.id.rbSelect)
        imgProfile = findViewById(R.id.imgProfile)
        rdoDooku = findViewById(R.id.rdoDooku)
        rdoMaul= findViewById(R.id.rdoMaul)
        rdoTano= findViewById(R.id.rdoTano)

        rdoTano.setOnClickListener {
            imgProfile.setImageResource(R.drawable.tano)
        }
        rdoDooku.setOnClickListener {
            imgProfile.setImageResource(R.drawable.dooku)
        }
        rdoMaul.setOnClickListener {
            imgProfile.setImageResource(R.drawable.maul)
        }


    }
}