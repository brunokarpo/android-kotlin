package com.example.bruno.animalbio

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var data = intent.extras

        detail_img_id.setImageDrawable(application.resources.getDrawable(data.getInt("idImage")))

        var name = getString(data.getInt("idName"))
        var detail = getString(data.getInt("idDetails"))

        name_text_id.text = name
        description_text_id.text = detail

    }
}
