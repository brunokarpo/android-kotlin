package com.example.bruno.mychatapp.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.bruno.mychatapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {


    var mDatabaseReference: DatabaseReference? = null
    var mCurrentUser: FirebaseUser? = null
    var mStorage: StorageReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        mCurrentUser = FirebaseAuth.getInstance().currentUser

        var userUID = mCurrentUser!!.uid

        mDatabaseReference = FirebaseDatabase.getInstance().reference
                .child("Users")
                .child(userUID)

        mDatabaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot?) {
                var displayName = snapshot!!.child("display_name").value
                var image = snapshot!!.child("image").value
                var status = snapshot!!.child("status").value
                var thumbnail = snapshot!!.child("thumb_image").value

                settings_status_text_id.text = status.toString()
                settings_display_name.text = displayName.toString()
            }

            override fun onCancelled(error: DatabaseError?) {

            }
        })


        settings_text_status_button_id.setOnClickListener {
            var intent = Intent(this, StatusActivity::class.java)
            intent.putExtra("status", settings_status_text_id.text.toString().trim())
            startActivity(intent)
        }

    }
}
