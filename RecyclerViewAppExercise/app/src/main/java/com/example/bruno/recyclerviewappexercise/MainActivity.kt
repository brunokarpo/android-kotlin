package com.example.bruno.recyclerviewappexercise

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.bruno.recyclerviewappexercise.contracts.ListCoinsContract
import com.example.bruno.recyclerviewappexercise.data.CoinAdapter
import com.example.bruno.recyclerviewappexercise.model.Coin
import com.example.bruno.recyclerviewappexercise.presenter.ListCoinPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListCoinsContract.ListCoinsView {

    private val REQUEST_CODE = 1

    private var presenter : ListCoinsContract.ListCoinsPresenter = ListCoinPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getCoins()

        button_new_element_id.setOnClickListener {
            var intent = Intent(this, CoinActivity::class.java)

            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun fillCoinRecyclerView(coins: ArrayList<Coin>) {
        var layoutManager = LinearLayoutManager(this)

        var adapter = CoinAdapter(coins, this)

        recycler_view_id.adapter = adapter
        recycler_view_id.layoutManager = layoutManager

        adapter.notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                presenter.getCoins()
                val message = resources.getText(R.string.new_coin_created_sucessfuly)
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        }
    }


}
