package com.example.bruno.mychatapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccountActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    var mDatabase: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        mAuth = FirebaseAuth.getInstance()

        account_create_act_btn.setOnClickListener {
            var email = account_display_email_edit_id.text.toString().trim()
            var password = account_display_password_edit_id.text.toString().trim()
            var displayName = account_display_name_edit_id.text.toString().trim()

            if (TextUtils.isEmpty(email).not().or(
                            TextUtils.isEmpty(password).not()
                    ).or(TextUtils.isEmpty(displayName).not())) {
                createAccount(email, password, displayName)
            } else {
                Toast.makeText(this, "Please fill out the fields", Toast.LENGTH_LONG)
                        .show()
            }
        }
    }


    fun createAccount( email: String, password: String, displayName: String) {
        mAuth!!.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    task: Task<AuthResult> ->

                    if (task.isSuccessful) {
                        var currentUser = mAuth!!.currentUser
                        var userId = currentUser!!.uid

                        mDatabase = FirebaseDatabase.getInstance().reference
                                .child("Users").child(userId)

                        var userObject = hashMapOf<String, String>()
                        userObject.put("display_name", displayName)
                        userObject.put("status", "Hello there...")
                        userObject.put("image", "default")
                        userObject.put("thumb_image", "default")

                        mDatabase!!.setValue(userObject).addOnCompleteListener {
                            task: Task<Void> ->
                            if (task.isSuccessful) {
                                Toast.makeText(this, "User created", Toast.LENGTH_LONG).show()
                            } else {
                                Toast.makeText(this, "User not created", Toast.LENGTH_LONG).show()
                            }
                        }

                    } else {

                    }
                }
    }
}
