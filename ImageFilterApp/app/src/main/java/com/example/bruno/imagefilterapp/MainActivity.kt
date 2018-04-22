package com.example.bruno.imagefilterapp

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorsArray = arrayOf(Color.BLACK, Color.CYAN, Color.BLUE, Color.GREEN, Color.DKGRAY,
                Color.RED, Color.WHITE)
        var porterModes = arrayOf(PorterDuff.Mode.OVERLAY, PorterDuff.Mode.DARKEN,
                PorterDuff.Mode.ADD, PorterDuff.Mode.CLEAR, PorterDuff.Mode.LIGHTEN,
                PorterDuff.Mode.DST)

        cat_image_view_id.setOnClickListener {
            val randomColor = getRandom(colorsArray.size)
            val randomPorterDuffMode = getRandom(porterModes.size)
            cat_image_view_id.setColorFilter(colorsArray[randomColor],
                    porterModes[randomPorterDuffMode])
        }
    }

    fun getRandom(arraySize: Int) : Int = Random().nextInt(arraySize)
}
