package com.example.bruno.choreapp.activity.createchore

import android.text.TextUtils
import com.example.bruno.choreapp.data.ChoreRepository
import com.example.bruno.choreapp.model.Chore

class CreateChorePresenterImpl(
        private val view: CreateChoreView,
        private val choreRepository: ChoreRepository)
    : CreateChorePresenter {

    override fun saveChore(choreName: String, assignedBy: String, assignedTo: String) {
        var chore = Chore()

        if (TextUtils.isEmpty(choreName)
                        .or(TextUtils.isEmpty(assignedBy))
                        .or(TextUtils.isEmpty(assignedTo))) {
            view.showMessageEnterAChore()
            return
        }

        chore.choreName = choreName
        chore.assignedTo = assignedTo
        chore.assignedBy = assignedBy

        choreRepository.createChore(chore)

        view.showMessageChoreCreatedSuccessfully()
        view.cleanFields()
        view.goToChoreListActivity()
    }
}