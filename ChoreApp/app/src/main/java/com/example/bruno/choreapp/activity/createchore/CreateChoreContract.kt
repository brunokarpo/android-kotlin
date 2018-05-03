package com.example.bruno.choreapp.activity.createchore

interface CreateChoreView{
    fun showMessageEnterAChore()
    fun showMessageChoreCreatedSuccessfully()
    fun cleanFields()
    fun goToChoreListActivity()
}

interface CreateChorePresenter{
    fun saveChore(choreName: String, assignedBy: String, assignedTo: String)
}
