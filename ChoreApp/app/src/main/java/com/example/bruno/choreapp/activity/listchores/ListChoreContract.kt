package com.example.bruno.choreapp.activity.listchores

import com.example.bruno.choreapp.model.Chore

interface ListChoreView {

    fun showChoreList(listChores: ArrayList<Chore>)

    fun goToNewChoreActivity()

    fun showPopUpNewChore()

    fun dismissPopUpNewChore()

    fun reloadList()

}

interface ListChorePresenter {

    fun retrieveAllChores()

    fun createChore(choreName: String, assignedTo: String, assignedBy: String)
}