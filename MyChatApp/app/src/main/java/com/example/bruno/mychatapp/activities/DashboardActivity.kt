package com.example.bruno.mychatapp.activities

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bruno.mychatapp.R
import com.example.bruno.mychatapp.adapters.SectionPagerAdapter
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    var sectionAdapter: SectionPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar!!.title = "Dashboard"

        sectionAdapter = SectionPagerAdapter(supportFragmentManager)
        dashboard_view_pager_id.adapter = sectionAdapter
        dashboard_main_tabs_id.setupWithViewPager(dashboard_view_pager_id)
        dashboard_main_tabs_id.setTabTextColors(Color.WHITE, Color.GREEN)

        if (intent.extras != null) {
            var username = intent.extras.getString("name")

            Toast.makeText(this, username, Toast.LENGTH_LONG).show()
        }
    }
}
