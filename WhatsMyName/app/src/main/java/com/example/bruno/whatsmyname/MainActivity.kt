package com.example.bruno.whatsmyname

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var enteredName = enter_name_edt_id.text

        show_name_button_id.setOnClickListener {
            result_text_id.text = enteredName
        }
    }
}
