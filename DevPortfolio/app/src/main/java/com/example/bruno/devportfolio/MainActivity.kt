package com.example.bruno.devportfolio

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.bruno.devportfolio.controller.DevPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerId.adapter = DevPagerAdapter(this, supportFragmentManager)
        tab_layout_id.setupWithViewPager(viewPagerId)

        tab_layout_id.setTabTextColors(Color.GRAY, Color.parseColor("white"))

        get_in_touch_button_id.setOnClickListener {
            val uri = "tel:6128879195"
            val phoneIntent = Intent(Intent.ACTION_DIAL)
            phoneIntent.setData(Uri.parse(uri))
            startActivity(intent)
        }
    }
}
