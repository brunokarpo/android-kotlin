package com.example.bruno.recyclerviewappexercise.contracts

import com.example.bruno.recyclerviewappexercise.model.Coin

interface ListCoinsContract {

    interface ListCoinsView {
        fun fillCoinRecyclerView(coins: ArrayList<Coin>)
    }

    interface ListCoinsPresenter {
        fun getCoins()
    }

}