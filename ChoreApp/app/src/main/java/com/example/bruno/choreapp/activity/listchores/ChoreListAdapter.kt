package com.example.bruno.choreapp.activity.listchores

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bruno.choreapp.R
import com.example.bruno.choreapp.model.Chore
import java.util.*

class ChoreListAdapter(
        private val list: ArrayList<Chore>,
        private val context: Context
    ): RecyclerView.Adapter<ChoreListAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater
                .from(context)
                .inflate(R.layout.chore_list_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {

        private var choreName = itemView!!.findViewById(R.id.list_chore_name_text_id) as TextView
        private var assignedBy = itemView!!.findViewById(R.id.list_assigned_by_text_id) as TextView
        private var assignedTo = itemView!!.findViewById(R.id.list_assigned_to_text_id) as TextView
        private var assignedDate = itemView!!.findViewById(R.id.list_chore_date_text_id) as TextView

        fun bindItem(chore: Chore) {

            choreName.text = chore.choreName
            assignedBy.text = chore.assignedBy
            assignedTo.text = chore.assignedTo
            assignedDate.text = chore.showHumanDate()

        }
    }
}