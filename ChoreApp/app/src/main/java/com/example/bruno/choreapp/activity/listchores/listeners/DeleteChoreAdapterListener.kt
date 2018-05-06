package com.example.bruno.choreapp.activity.listchores.listeners

import android.view.View
import com.example.bruno.choreapp.activity.listchores.ChoreAdapterPresenter
import com.example.bruno.choreapp.model.Chore

class DeleteChoreAdapterListener(
        private val chore: Chore,
        private val presenter: ChoreAdapterPresenter
    ): View.OnClickListener {


    override fun onClick(v: View?) {
        presenter.deleteChore(chore)
    }
}