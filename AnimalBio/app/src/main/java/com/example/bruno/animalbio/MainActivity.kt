package com.example.bruno.animalbio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cheetah = cheeta_img_id
        var lion = lion_img_id

        cheetah.setOnClickListener(ImageAnimalListener(AnimalDetails.CHEETAH))
        lion.setOnClickListener(ImageAnimalListener(AnimalDetails.LION))

    }
}
