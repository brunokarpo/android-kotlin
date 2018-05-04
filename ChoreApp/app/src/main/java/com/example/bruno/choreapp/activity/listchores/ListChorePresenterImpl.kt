package com.example.bruno.choreapp.activity.listchores

import com.example.bruno.choreapp.data.ChoreRepository

class ListChorePresenterImpl(
        private val view: ListChoreView,
        private val repository: ChoreRepository
    ): ListChorePresenter {


    override fun retrieveAllChores() {
        var choresList = repository.readChores()

        if (choresList.isEmpty()) {
            view.goToNewChoreActivity()
            return
        }

        view.showChoreList(choresList)
    }
}