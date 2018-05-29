package com.example.bruno.motivationalapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.example.bruno.motivationalapp.controller.AppController
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getInfo("https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20")
    }

    fun getInfo(url: String) {
        val quoteRequest = JsonArrayRequest(Request.Method.GET, url,
                Response.Listener {
                    response: JSONArray ->
                    try {
                        Log.d("Information", response.toString())
                    } catch(e: JSONException) { e.printStackTrace() }
                },
                Response.ErrorListener {
                    error: VolleyError? ->
                    try {
                        Log.d("Error", "Not working")
                    } catch (e: JSONException) { e.printStackTrace() }
                })

        AppController.instance!!.addToRuquestQueue(quoteRequest)
    }
}
