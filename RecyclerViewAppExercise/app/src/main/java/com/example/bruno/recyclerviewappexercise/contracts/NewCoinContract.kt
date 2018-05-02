package com.example.bruno.recyclerviewappexercise.contracts

interface NewCoinContract {

    interface NewCoinView {

        fun completeActivity()

    }

    interface NewCoinPresenter {
        fun addNewCoin(name: String, value: Double)
    }
}