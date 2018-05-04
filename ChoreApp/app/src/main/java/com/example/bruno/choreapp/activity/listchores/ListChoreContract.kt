package com.example.bruno.choreapp.activity.listchores

import com.example.bruno.choreapp.model.Chore

interface ListChoreView {

    fun showChoreList(listChores: ArrayList<Chore>)

    fun goToNewChoreActivity()

}

interface ListChorePresenter {

    fun retrieveAllChores()
}