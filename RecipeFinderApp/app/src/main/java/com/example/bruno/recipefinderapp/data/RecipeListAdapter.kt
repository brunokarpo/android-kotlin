package com.example.bruno.recipefinderapp.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.bruno.recipefinderapp.R
import com.example.bruno.recipefinderapp.model.Recipe
import com.squareup.picasso.Picasso

class RecipeListAdapter(
        private val list: ArrayList<Recipe>,
        private val context: Context
    ): RecyclerView.Adapter<RecipeListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context)
                .inflate(R.layout.list_row_recipe, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var title = itemView.findViewById(R.id.recipe_title_text_id) as TextView
        var ingredients = itemView.findViewById(R.id.recipe_ingredients_text_id) as TextView
        var thumbnail = itemView.findViewById(R.id.thumbnail) as ImageView
        var linkButton = itemView.findViewById(R.id.link_button) as Button

        fun bindItem(recipe: Recipe) {
            title.text = recipe.title
            ingredients.text = recipe.ingredients
            linkButton.setOnClickListener {  }

            if (!TextUtils.isEmpty(recipe.thumbnail)) {
                Picasso.get()
                        .load(recipe.thumbnail)
                        .placeholder(R.drawable.recipe_icon)
                        .error(R.drawable.recipe_icon)
                        .into(thumbnail)
            }
        }
    }
}