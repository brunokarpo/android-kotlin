package com.example.bruno.devportfolio

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bruno.devportfolio.controller.DevPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerId.adapter = DevPagerAdapter(this, supportFragmentManager)
        tab_layout_id.setupWithViewPager(viewPagerId)

        tab_layout_id.setTabTextColors(Color.GRAY, Color.parseColor("white"))
    }
}
