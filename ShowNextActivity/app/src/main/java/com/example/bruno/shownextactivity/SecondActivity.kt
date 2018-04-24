package com.example.bruno.shownextactivity

import android.app.Activity
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

        go_back_button_id.setOnClickListener {
            var returnIntent = this.intent
            returnIntent.putExtra(Constants.HELLO_FROM_SECOND.name, this.getString(R.string.hello_from_second))
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}
