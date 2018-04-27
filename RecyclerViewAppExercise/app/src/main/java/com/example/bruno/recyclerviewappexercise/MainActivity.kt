package com.example.bruno.recyclerviewappexercise

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.bruno.recyclerviewappexercise.data.CoinAdapter
import com.example.bruno.recyclerviewappexercise.model.Coin
import com.example.bruno.recyclerviewappexercise.repository.CoinRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var coinRepository: CoinRepository? = null

    private var adapter: CoinAdapter? = null
    private var coinsList: ArrayList<Coin>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // contains all coins
        coinRepository = CoinRepository.instance

        // retrieve coins of repository
        coinsList = coinRepository!!.getAll()

        // configuring layout manager
        layoutManager = LinearLayoutManager(this)

        // creating adapter to list
        adapter = CoinAdapter(coinsList!!, this)


        // setting layout manager to recycler view
        recycler_view_id.layoutManager = layoutManager
        // setting adapter to recycler view
        recycler_view_id.adapter = adapter

        // add notification when datas change
        adapter!!.notifyDataSetChanged()
    }
}
