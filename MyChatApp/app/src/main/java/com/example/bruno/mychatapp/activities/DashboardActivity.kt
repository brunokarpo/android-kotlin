package com.example.bruno.mychatapp.activities

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.bruno.mychatapp.R
import com.example.bruno.mychatapp.adapters.SectionPagerAdapter
import com.google.firebase.auth.FirebaseAuth
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        super.onOptionsItemSelected(item)

        if (item != null) {
            when (item!!.itemId) {
                R.id.logout_id -> {
                    FirebaseAuth.getInstance().signOut()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                R.id.settings_id -> {
                    startActivity(Intent(this, SettingsActivity::class.java))
                }
            }
        }

        return true
    }
}
