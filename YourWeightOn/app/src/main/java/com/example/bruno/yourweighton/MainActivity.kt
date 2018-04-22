package com.example.bruno.yourweighton

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mars_checkbox_id.setOnClickListener(PlanetCheckboxListener(Planets.MARS, this))
        venus_checkbox_id.setOnClickListener(PlanetCheckboxListener(Planets.VENUS, this))
        jupter_checkbox_id.setOnClickListener(PlanetCheckboxListener(Planets.JUPTER, this))
    }

}
