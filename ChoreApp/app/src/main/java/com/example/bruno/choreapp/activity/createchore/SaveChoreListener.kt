package com.example.bruno.choreapp.activity.createchore

import android.view.View
import android.widget.EditText

class SaveChoreListener(
        private val enterChore: EditText,
        private val assignedBy: EditText,
        private val assignedTo: EditText,
        private val presenter: CreateChorePresenter
    ) : View.OnClickListener {

    override fun onClick(v: View?) {
            presenter.saveChore(enterChore.text.toString(),
                    assignedBy.text.toString(),
                    assignedTo.text.toString())
    }
}