package com.example.bruno.recyclerviewappexercise.presenter

import com.example.bruno.recyclerviewappexercise.contracts.NewCoinContract
import com.example.bruno.recyclerviewappexercise.model.Coin
import com.example.bruno.recyclerviewappexercise.repository.CoinRepository

class NewCoinPresenterImpl(private val newCoinView: NewCoinContract.NewCoinView): NewCoinContract.NewCoinPresenter {

    private var coinRepository = CoinRepository.instance

    override fun addNewCoin(name: String, value: Double) {
        var coin = Coin()

        coin.name = name
        coin.value = value

        coinRepository.save(coin)

        newCoinView.completeActivity()
    }
}