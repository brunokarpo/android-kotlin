package com.example.bruno.recyclerviewappexercise.presenter

import com.example.bruno.recyclerviewappexercise.contracts.ListCoinsContract
import com.example.bruno.recyclerviewappexercise.repository.CoinRepository

class ListCoinPresenterImpl(private var listCoinView: ListCoinsContract.ListCoinsView): ListCoinsContract.ListCoinsPresenter {

    private var coinRepository: CoinRepository = CoinRepository.instance;

    override fun getCoins() {
        var coins = coinRepository.getAll()
        listCoinView.fillCoinRecyclerView(coins)
    }

}