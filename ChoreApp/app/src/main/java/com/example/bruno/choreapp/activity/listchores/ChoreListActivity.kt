package com.example.bruno.choreapp.activity.listchores

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.bruno.choreapp.R
import com.example.bruno.choreapp.data.ChoreRepository
import com.example.bruno.choreapp.data.ChoresDatabaseHandler
import com.example.bruno.choreapp.model.Chore
import kotlinx.android.synthetic.main.activity_chore_list.*

class ChoreListActivity : AppCompatActivity(), ListChoreView {

    private var presenter: ListChorePresenter? = null

    private var choreRepository: ChoreRepository? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chore_list)

        choreRepository = ChoresDatabaseHandler(this)
        presenter = ListChorePresenterImpl(this, choreRepository!!)

        presenter!!.retrieveAllChores()
    }

    override fun showChoreList(listChores: ArrayList<Chore>) {
        var layoutManager = LinearLayoutManager(this)
        var adapter = ChoreListAdapter(listChores, this)

        list_chores_recycler_view_id.layoutManager = layoutManager
        list_chores_recycler_view_id.adapter = adapter

        adapter.notifyDataSetChanged()
    }
}
