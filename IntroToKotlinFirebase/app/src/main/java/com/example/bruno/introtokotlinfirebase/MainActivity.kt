package com.example.bruno.introtokotlinfirebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firebaseDatabase = FirebaseDatabase.getInstance()
        var databaseRef = firebaseDatabase.getReference("messages")

        databaseRef.setValue("Hello There")


        // Read from our DB
        databaseRef.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                var value = dataSnapshot!!.value

                Log.d("Value====>>>", value.toString())
            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.e("Error=====>>", databaseError!!.toString())
            }
        })
    }
}
