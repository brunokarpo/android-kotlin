package com.example.bruno.volleyapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    var volleyRequest: RequestQueue? = null
    val stringLink: String = "https://www.magadistudio.com/complete-android-developer-course-source-files/string.html"
    val jsonLink: String = "https://private-2ce0c-brunokarpo.apiary-mock.com/people"
    val jsonObjectLink: String = "http://private-2ce0c-brunokarpo.apiary-mock.com/people/93962802592"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        volleyRequest = Volley.newRequestQueue(this)

        getString(stringLink)
        getJsonArray(jsonLink)
        getJsonObject(jsonObjectLink)
    }

    fun getJsonObject(url: String) {
        val jsonObjectReq = JsonObjectRequest(Request.Method.GET, url,
                Response.Listener {
                    response: JSONObject ->
                    try {
                        Log.d("Response Json Object", response.toString())

                        val name = response.getString("name")
                        val cpf = response.getString("cpf")
                        val enderecoObj = response.getJSONObject("endereco")
                        val rua = enderecoObj.getString("rua")
                        val numero = enderecoObj.getInt("numero")
                        val bairro = enderecoObj.getString("bairro")
                        val telefonesArray = response.getJSONArray("telefones")

                        var stringMessage = "Nome: $name\nCPF: $cpf\n" +
                                "Endereço: $rua, $numero, Bairro: $bairro\n" +
                                "Telefones: "

                        for (i in 0 until telefonesArray.length()) {
                            stringMessage += telefonesArray.get(i).toString()
                            stringMessage += " "
                        }

                        Log.d("Detail person", stringMessage)


                    } catch (e: JSONException) { e.printStackTrace() }
                },
                Response.ErrorListener {
                    error: VolleyError? ->
                    try{

                    } catch (e: JSONException) { e.printStackTrace() }
                })

        volleyRequest!!.add(jsonObjectReq)
    }

    fun getJsonArray(url: String) {
        val jsonReq = JsonArrayRequest(Request.Method.GET, url,
                Response.Listener {
                    response: JSONArray ->
                    try {
                        Log.d("Response ========>>", response.toString())

                        for(i in 0 until response.length() - 1) {
                            val peopleObj = response.getJSONObject(i)

                            var nome = peopleObj.getString("name")
                            Log.d("Person name: ", nome)

                        }
                    } catch (e: JSONException) { e.printStackTrace() }
                },
                Response.ErrorListener {
                    error: VolleyError? ->
                    try {
                        Log.e("Error", error!!.toString())

                    } catch (ex: JSONException) { ex.printStackTrace() }
                })
        volleyRequest!!.add(jsonReq)
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
