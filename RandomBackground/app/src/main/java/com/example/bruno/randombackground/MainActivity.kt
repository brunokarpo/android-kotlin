package com.example.bruno.randombackground

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorsArray = arrayOf(Color.BLACK, Color.WHITE, Color.RED, Color.GREEN,
                Color.TRANSPARENT, Color.DKGRAY, Color.BLUE, Color.CYAN, Color.LTGRAY,
                Color.YELLOW)

        tap_button_id.setOnClickListener {
            val randomColor = Random().nextInt(colorsArray.size)
            main_view_id.setBackgroundColor(colorsArray[randomColor])
        }
    }
}
