package com.example.bruno.sharedprefsapp

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val PREFS_NAME = "myPrefs"
    private var myPrefs: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save_button_id.setOnClickListener {
            myPrefs = getSharedPreferences(PREFS_NAME, 0)
            var editor: SharedPreferences.Editor = myPrefs!!.edit()

            if (!TextUtils.isEmpty(enter_something_text_id.text.toString())) {
                var message = enter_something_text_id.text.toString()
                editor.putString("message", message)
                editor.commit()

            } else {
                Toast.makeText(this,
                        getText(R.string.please_enter_something),
                        Toast.LENGTH_LONG)
                    .show()
            }
        }


        var dataBack: SharedPreferences = getSharedPreferences(PREFS_NAME, 0)
        if(dataBack.contains("message")) {
            var myMessage = dataBack.getString("message", "not found")

            result_text_id.text = myMessage
        }
    }
}
