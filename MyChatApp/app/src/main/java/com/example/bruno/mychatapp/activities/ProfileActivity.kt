package com.example.bruno.mychatapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bruno.mychatapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    var mCurrentUser: FirebaseUser? = null
    var mUsersDatabase: DatabaseReference? = null
    var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        supportActionBar!!.title = "Profile"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if (intent.extras != null) {
            userId = intent.extras.getString("userId")

            mCurrentUser = FirebaseAuth.getInstance().currentUser
            mUsersDatabase = FirebaseDatabase.getInstance().reference
                    .child("Users")
                    .child(userId)

            setUpProfile()
        }
    }

    private fun setUpProfile() {
        mUsersDatabase!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                var displayName = dataSnapshot!!.child("display_name").value.toString()
                var status = dataSnapshot!!.child("status").value.toString()
                var image = dataSnapshot!!.child("image").value.toString()

                profile_name_text_id.text = displayName
                profile_status_text_id.text = status

                Picasso.get()
                        .load(image)
                        .placeholder(R.drawable.profile_img)
                        .into(profile_picture_id)

            }

            override fun onCancelled(databaseError: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}
