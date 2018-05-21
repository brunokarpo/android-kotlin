package com.example.bruno.recipefinderapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bruno.recipefinderapp.R
import kotlinx.android.synthetic.main.activity_show_link.*

class ShowLinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_link)

        var extra = intent.extras
        if (extra != null) {
            var link = extra.getString("link")

            web_view_id.loadUrl(link)
        }
    }
}
