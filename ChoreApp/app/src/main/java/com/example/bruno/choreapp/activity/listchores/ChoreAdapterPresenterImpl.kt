package com.example.bruno.choreapp.activity.listchores

import com.example.bruno.choreapp.data.ChoreRepository
import com.example.bruno.choreapp.model.Chore

class ChoreAdapterPresenterImpl(
        private val view: ChoreAdapterView,
        private val repository: ChoreRepository
    ): ChoreAdapterPresenter {

    override fun deleteChore(chore: Chore) {
        repository.deleteChore(chore)
        view.removeChoreOfList(chore)
    }

    override fun updateChore(chore: Chore) {
        repository.updateChore(chore)
        view.updateChoreOnList(chore)
    }
}