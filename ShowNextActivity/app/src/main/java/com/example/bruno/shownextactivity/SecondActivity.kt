package com.example.bruno.shownextactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var data = intent.extras

        if (data != null) {
            var name = data.get(Constants.NAME.name)

            title_hello_id.text = "Hi $name! Welcome to second activity"
        }
    }
}
