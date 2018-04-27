package com.example.bruno.recyclerviewappexercise.repository

import com.example.bruno.recyclerviewappexercise.model.Coin

class CoinRepository {

    private var coins: MutableList<Coin>? = null

    private constructor() {
        coins = mutableListOf<Coin>()
        coins!!.add(Coin("Bitcoin", 8000.0001))
        coins!!.add(Coin("Bicoin Cash", 600.7))
        coins!!.add(Coin("Litecoin", 450.03))
        coins!!.add(Coin("Monero", 52.5))
    }

    fun getAll(): ArrayList<Coin> {
        return ArrayList(coins)
    }

    companion object {

        var instance = CoinRepository()
    }
}