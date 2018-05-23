package com.example.bruno.mychatapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bruno.mychatapp.R

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar!!.title = "Dashboard"

        if (intent.extras != null) {
            var username = intent.extras.getString("name")

            Toast.makeText(this, username, Toast.LENGTH_LONG).show()
        }
    }
}
