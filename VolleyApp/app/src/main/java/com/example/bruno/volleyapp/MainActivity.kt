package com.example.bruno.volleyapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    var volleyRequest: RequestQueue? = null
    val stringLink: String = "https://www.magadistudio.com/complete-android-developer-course-source-files/string.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        volleyRequest = Volley.newRequestQueue(this)

        getString(stringLink)
    }

    fun getString(url: String) {
        val stringReq = StringRequest(Request.Method.GET, url,
                Response.Listener {
                    response: String ->
                    try {
                        Log.d("Response: ", response)
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }

                },
                Response.ErrorListener {
                    error: VolleyError? ->
                    try {
                        Log.e("Error", error.toString())
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                })
        volleyRequest!!.add(stringReq)
    }
}
