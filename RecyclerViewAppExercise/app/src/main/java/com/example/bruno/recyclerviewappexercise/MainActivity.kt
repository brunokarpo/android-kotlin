package com.example.bruno.recyclerviewappexercise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.bruno.recyclerviewappexercise.data.CoinAdapter
import com.example.bruno.recyclerviewappexercise.repository.CoinRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var coinRepository: CoinRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // contains all coins
        coinRepository = CoinRepository.instance

        createAndFillRecyclerView()
    }

    private fun createAndFillRecyclerView() {
        // retrieve coins of repository
        var coinsList = coinRepository!!.getAll()

        // configuring layout manager
        var layoutManager = LinearLayoutManager(this)

        // creating adapter to list
        var adapter = CoinAdapter(coinsList!!, this)

        // setting layout manager to recycler view
        recycler_view_id.layoutManager = layoutManager
        // setting adapter to recycler view
        recycler_view_id.adapter = adapter

        // add notification when datas change
        adapter.notifyDataSetChanged()
    }
}
