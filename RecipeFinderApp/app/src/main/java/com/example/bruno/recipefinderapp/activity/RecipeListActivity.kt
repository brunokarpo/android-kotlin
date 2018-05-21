package com.example.bruno.recipefinderapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.bruno.recipefinderapp.R
import com.example.bruno.recipefinderapp.data.RecipeListAdapter
import com.example.bruno.recipefinderapp.model.Recipe
import kotlinx.android.synthetic.main.activity_recipe_list.*
import org.json.JSONException

class RecipeListActivity : AppCompatActivity() {

    var volleyRequest: RequestQueue? = null
    var recipeList: ArrayList<Recipe>? = null
    var recipeAdapter: RecipeListAdapter? = null
    var layoutManager: RecyclerView.LayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        var urlString = "http://www.recipepuppy.com/api/"

        recipeList = ArrayList()

        volleyRequest = Volley.newRequestQueue(this)

        getRecipe(urlString)

    }

    fun getRecipe(url: String) {
        val recipeRequest = JsonObjectRequest(Request.Method.GET, url,
                Response.Listener {
                    response ->
                    try {

                        val resultArray = response.getJSONArray("results")

                        for (i in 0 until resultArray.length()) {
                            var recipeObject = resultArray.getJSONObject(i)
                            var title = recipeObject.getString("title")
                            var ingredients = recipeObject.getString("ingredients")
                            var thumbnail = recipeObject.getString("thumbnail")
                            var href = recipeObject.getString("href")

                            Log.d("Result====>", title)

                            var recipe = Recipe(title, ingredients, thumbnail, href)
                            recipeList!!.add(recipe)
                        }

                        recipeAdapter = RecipeListAdapter(recipeList!!, this)
                        layoutManager = LinearLayoutManager(this)

                        recipe_recycler_view_id.layoutManager = layoutManager
                        recipe_recycler_view_id.adapter = recipeAdapter

                        recipeAdapter?.notifyDataSetChanged()

                    } catch (ex: JSONException) { ex.printStackTrace() }
                },
                Response.ErrorListener {
                    error: VolleyError? ->
                    try {
                        Log.e("Error ===> ", error.toString())
                    } catch (ex: JSONException) { ex.printStackTrace() }
                })

        volleyRequest!!.add(recipeRequest)
    }
}
