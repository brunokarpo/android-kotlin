package com.example.bruno.mychatapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bruno.mychatapp.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
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

            mCurrentUser = FirebaseAuth.getInstance().currentUser
            var userId = mCurrentUser!!.uid

            mDatabaseReference = FirebaseDatabase.getInstance().reference
                    .child("Users").child(userId)

            var status = status_update_edit_text_id.text.toString().trim()

            mDatabaseReference!!.child("status")
                    .setValue(status).addOnCompleteListener {
                        task: Task<Void> ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Status updated successufully!", Toast.LENGTH_LONG)
                                    .show()

                            startActivity(Intent(this, SettingsActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "Status not updated!", Toast.LENGTH_LONG)
                                    .show()
                        }
                    }

        }
    }
}
