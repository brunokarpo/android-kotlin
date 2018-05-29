package com.example.bruno.motivationalapp.controller

import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.example.bruno.motivationalapp.model.Quote
import org.json.JSONArray
import org.json.JSONException

class QuoteData {
    lateinit var quoteArrayList: ArrayList<Quote>

    fun getQuotes(callback: QuoteListAsyncResponse) {
        val url = "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20"

        val quoteRequest = JsonArrayRequest(Request.Method.GET, url,
            Response.Listener {
                response: JSONArray ->
                val quotes = arrayListOf<Quote>()
                try {
                    for(i in 0 until response.length()) {
                        var quoteObject = response.getJSONObject(i)
                        var quote = Quote(quoteObject.getString("quote"), quoteObject.getString("name"))
                        quotes.add(quote)
                    }
                } catch(e: JSONException) { e.printStackTrace() }
                callback.processFinished(quotes)
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