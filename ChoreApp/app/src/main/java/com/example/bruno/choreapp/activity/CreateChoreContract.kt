package com.example.bruno.choreapp.activity

interface CreateChoreView{
    fun showMessageEnterAChore()
    fun showMessageChoreCreatedSuccessfully()
    fun cleanFields()
}

interface CreateChorePresenter{
    fun saveChore(choreName: String, assignedBy: String, assignedTo: String)
}
