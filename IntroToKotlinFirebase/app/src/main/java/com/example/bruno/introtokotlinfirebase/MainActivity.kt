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
        var databaseRef = firebaseDatabase.getReference("messages").push()

        var employee = Employee("Jane Bond", "Android Developer",
                "123 South Street", 32)

        databaseRef.setValue(employee)

        // Read from our DB
        databaseRef.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                var value = dataSnapshot!!.value as HashMap<String, Any>

                Log.d("Value====>>>", value.get("name").toString())
            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.e("Error=====>>", databaseError!!.toString())
            }
        })
    }


    data class Employee(var name: String, var position: String,
                        var homeAddress: String, var age: Int)
}
