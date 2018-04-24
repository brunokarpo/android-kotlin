package com.example.bruno.shownextactivity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        go_to_second_button_id.setOnClickListener {
            var name = name_edt_id.text

            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.NAME.name, name)

            startActivityForResult(intent, REQUEST_CODE)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if(resultCode == Activity.RESULT_OK) {
                var result = data?.extras!!.get(Constants.HELLO_FROM_SECOND.name).toString()
                Toast.makeText(this, result, Toast.LENGTH_LONG).show()
            }
        }
    }
}
