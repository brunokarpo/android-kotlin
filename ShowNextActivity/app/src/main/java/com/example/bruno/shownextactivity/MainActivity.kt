package com.example.bruno.shownextactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        go_to_second_button_id.setOnClickListener {
//            var intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)

            // the best way to start an activity
            startActivity( Intent(this, SecondActivity::class.java) )
        }
    }
}
