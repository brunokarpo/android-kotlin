package com.example.bruno.mychatapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bruno.mychatapp.R
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_status.*

class StatusActivity : AppCompatActivity() {

    var mDatabaseReference: DatabaseReference? = null
    var mCurrentUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)

        supportActionBar!!.title = "Status"

        if (intent.extras != null) {
            var oldstatus = intent.extras.getString("status")

            status_update_edit_text_id.setText(oldstatus.toString())
        } else {
            status_update_edit_text_id.setText("Enter your new Status")
        }

        status_update_button_id.setOnClickListener {
            
        }
    }
}
