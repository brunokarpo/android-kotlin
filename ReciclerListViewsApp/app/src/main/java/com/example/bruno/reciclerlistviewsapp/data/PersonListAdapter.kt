package com.example.bruno.reciclerlistviewsapp.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.bruno.reciclerlistviewsapp.R
import com.example.bruno.reciclerlistviewsapp.model.Person

class PersonListAdapter(private val list: ArrayList<Person>,
                        private val context: Context) : RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.my_list_row, parent, false)

        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list.get(position))
    }


    class ViewHolder(itemView: View, val context: Context): RecyclerView.ViewHolder(itemView) {
        fun bindItem(person: Person) {
            var name: TextView = itemView.findViewById(R.id.name_text_id)
            var age: TextView = itemView.findViewById(R.id.age_text_id)
            var image: ImageView = itemView.findViewById(R.id.pic_view_id)

            name.text = person.name
            age.text = person.age.toString()
            image.setImageDrawable(context.applicationContext.resources.getDrawable(person.idImage!!))
        }
    }

}