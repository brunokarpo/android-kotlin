package com.example.bruno.mychatapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    var mDatabase: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        login_button_id.setOnClickListener {
            var email = login_email_edit_id.text.toString().trim()
            var password = login_password_edit_id.text.toString().trim()

            if (TextUtils.isEmpty(email).not().or(TextUtils.isEmpty(password).not())) {
                loginUser(email, password)

            } else {
                Toast.makeText(this, "Sorry, login failed!", Toast.LENGTH_LONG).show()
            }

        }
    }

    fun loginUser(email: String, password: String) {

        mAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    task: Task<AuthResult> ->
                    if (task.isSuccessful) {
                        var displayName = email.split("@")[0] //GAMBI...

                        var dashboardIntent = Intent(this, DashboardActivity::class.java)
                        dashboardIntent.putExtra("name", displayName)

                        startActivity(dashboardIntent)
                        finish()

                    } else {
                        Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show()
                    }
                }
    }
}
