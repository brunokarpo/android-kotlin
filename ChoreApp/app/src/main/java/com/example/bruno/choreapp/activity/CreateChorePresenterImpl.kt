package com.example.bruno.choreapp.activity

import com.example.bruno.choreapp.data.ChoreRepository

class CreateChorePresenterImpl(
        private val view: CreateChoreContract.CreateChoreView,
        private val choreRepository: ChoreRepository)
    : CreateChoreContract.CreateChorePresenter {
}