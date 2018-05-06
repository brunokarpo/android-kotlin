package com.example.bruno.choreapp.activity.listchores

import com.example.bruno.choreapp.model.Chore

interface ChoreAdapterView {
    fun removeChoreOfList(chore: Chore)
}

interface ChoreAdapterPresenter {

    fun deleteChore(chore: Chore)

}