package com.example.bruno.recipefinderapp.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.bruno.recipefinderapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search_button_id.setOnClickListener {
            var intent = Intent(this, RecipeListActivity::class.java)

            var ingredients = ingredients_edit_id.text.toString().trim()
            var searchTerm = search_terms_edit_id.text.toString().trim()

            intent.putExtra("ingredients", ingredients)
            intent.putExtra("search", searchTerm)

            startActivity(intent)
        }

    }
}
