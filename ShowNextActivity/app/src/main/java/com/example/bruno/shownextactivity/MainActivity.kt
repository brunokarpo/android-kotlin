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
            var name = name_edt_id.text

            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.NAME.name, name)

            startActivity(intent)

        }
    }
}
