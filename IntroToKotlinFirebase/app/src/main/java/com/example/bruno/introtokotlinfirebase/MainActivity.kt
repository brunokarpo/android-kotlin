package com.example.bruno.introtokotlinfirebase

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private var currentUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firebaseDatabase = FirebaseDatabase.getInstance()
        var databaseRef = firebaseDatabase.getReference("messages").push()

        mAuth = FirebaseAuth.getInstance()

        mAuth!!.signInWithEmailAndPassword("bruno@me.com", "password")
                .addOnCompleteListener{
                    task: Task<AuthResult> ->
                    if(task.isSuccessful) {
                        Toast.makeText(this, "Signed In Successfull", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "Signed In Unsuccessfull", Toast.LENGTH_LONG).show()
                    }
                }

//        var employee = Employee("Jane Bond", "Android Developer",
//                "123 South Street", 32)

//        databaseRef.setValue(employee)

        // Read from our DB
//        databaseRef.addValueEventListener(object : ValueEventListener{
//
//            override fun onDataChange(dataSnapshot: DataSnapshot?) {
////                var value = dataSnapshot!!.value as HashMap<String, Any>
////
////                Log.d("Value====>>>", value.get("name").toString())
//            }
//
//            override fun onCancelled(databaseError: DatabaseError?) {
////                Log.e("Error=====>>", databaseError!!.toString())
//            }
//        })
    }


    override fun onStart() {
        super.onStart()

        currentUser = mAuth!!.currentUser

        if (currentUser != null) {
            Toast.makeText(this, "User is logged in", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "User is logged out", Toast.LENGTH_LONG).show()
        }
    }

    data class Employee(var name: String, var position: String,
                        var homeAddress: String, var age: Int)
}
