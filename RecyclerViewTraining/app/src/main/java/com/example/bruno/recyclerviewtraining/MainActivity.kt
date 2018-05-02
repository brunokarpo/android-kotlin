package com.example.bruno.recyclerviewtraining

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.bruno.recyclerviewtraining.model.Fly
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListFliesContract.ListFliesView {

    private val presenter: ListFliesContract.ListFliesPresenter = ListFliesPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.retrieveFlies()
    }

    override fun fillFliesInList(flies: ArrayList<Fly>) {
        var layoutManager = LinearLayoutManager(this)

        var adapter = FlyAdapter(flies, this)

        recycler_view_id.layoutManager = layoutManager
        recycler_view_id.adapter = adapter

        adapter.notifyDataSetChanged()
    }
}
