package com.example.bruno.choreapp.activity

import android.view.View
import android.widget.EditText

class SaveChoreListener(
        private val enterChore: EditText,
        private val assignedBy: EditText,
        private val assignedTo: EditText,
        private val presenter: CreateChoreContract.CreateChorePresenter?
    ) : View.OnClickListener {

    override fun onClick(v: View?) {

    }
}