package com.example.bruno.recyclerviewtraining

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bruno.recyclerviewtraining.model.Fly

class FlyAdapter(private var flies: ArrayList<Fly>,
                 private var context: Context): RecyclerView.Adapter<FlyAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return flies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fly_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(flies.get(position))
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(fly: Fly) {
            var companyName: TextView = itemView.findViewById(R.id.company_name_text_id)
            var fromWhere: TextView = itemView.findViewById(R.id.from_where_text_id)
            var toWhere: TextView = itemView.findViewById(R.id.to_where_text_id)

            companyName.text = fly.companyName
            fromWhere.text = fly.fromWhere
            toWhere.text = fly.toWhere
        }

    }
}