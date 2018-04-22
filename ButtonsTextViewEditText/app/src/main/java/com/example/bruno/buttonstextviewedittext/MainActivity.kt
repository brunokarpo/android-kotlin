package com.example.bruno.buttonstextviewedittext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name = enter_name_edt_id.text
        show_name_button_id.setOnClickListener {
            var message = "Enter name"
            if (!name.isEmpty()) {
                message = "Welcome $name"
            }
            result_txt_id.text = message
        }
    }
}
