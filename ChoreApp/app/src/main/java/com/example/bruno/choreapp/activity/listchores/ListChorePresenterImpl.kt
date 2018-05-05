package com.example.bruno.choreapp.activity.listchores

import android.text.TextUtils
import com.example.bruno.choreapp.data.ChoreRepository
import com.example.bruno.choreapp.model.Chore

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

    override fun createChore(choreName: String, assignedTo: String, assignedBy: String) {
        if (TextUtils.isEmpty(choreName.trim()).not()
                        .and(TextUtils.isEmpty(assignedBy.trim()).not())
                        .and(TextUtils.isEmpty(assignedTo.trim()).not())) {
            var chore = Chore(choreName, assignedBy, assignedTo)

            repository.createChore(chore)

            view.dismissPopUpNewChore()
            view.reloadList()
        }
    }


}