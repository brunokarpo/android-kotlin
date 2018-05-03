package com.example.bruno.choreapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bruno.choreapp.R
import com.example.bruno.choreapp.data.ChoreRepository
import com.example.bruno.choreapp.data.ChoresDatabaseHandler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CreateChoreContract.CreateChoreView {

    private var presenter: CreateChoreContract.CreateChorePresenter? = null
    private var dbHandler: ChoreRepository? = null
    private var enterChore = enter_chore_edit_id
    private var assignedBy = assigned_by_edit_id
    private var assignedTo = assign_to_edit_id
    private var saveChore = save_chore_button_id

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = ChoresDatabaseHandler(this)
        presenter = CreateChorePresenterImpl(this, dbHandler!!)

        saveChore.setOnClickListener(SaveChoreListener(enterChore, assignedBy, assignedTo, presenter))
    }
}
