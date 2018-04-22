package com.example.bruno.imageviewapp

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cat_img_id.setColorFilter(Color.BLUE)
        dog_img_id.setColorFilter(Color.CYAN)

        cat_img_id.setOnClickListener {
            cat_img_id.clearColorFilter()
//            cat_img_id.setColorFilter(Color.GREEN, PorterDuff.Mode.DARKEN)
            cat_img_id.setBackgroundColor(Color.MAGENTA)
        }
    }
}
