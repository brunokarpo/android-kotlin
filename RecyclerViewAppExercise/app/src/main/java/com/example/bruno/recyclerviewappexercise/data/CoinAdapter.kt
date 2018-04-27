package com.example.bruno.recyclerviewappexercise.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bruno.recyclerviewappexercise.R
import com.example.bruno.recyclerviewappexercise.model.Coin

class CoinAdapter(private var list: ArrayList<Coin>,
                  private var context: Context) : RecyclerView.Adapter<CoinAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_row_coin, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list.get(position))
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(coin: Coin) {
            var name: TextView = itemView.findViewById(R.id.name_coin_text_id)
            var value: TextView = itemView.findViewById(R.id.value_coin_text_id)

            name.text = coin.name
            value.text = "$ ${coin.value!!.format(2)}"
        }


    }
}

private fun Double.format(decimals: Int): String = String.format("%.${decimals}f", this)