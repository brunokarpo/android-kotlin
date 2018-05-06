package com.example.bruno.choreapp.activity.listchores.listeners

import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import com.example.bruno.choreapp.R
import com.example.bruno.choreapp.activity.listchores.ChoreAdapterPresenter
import com.example.bruno.choreapp.model.Chore
import kotlinx.android.synthetic.main.pop_up_new_chore.view.*

class EditChoreAdapterListener(
        private val chore: Chore,
        private val presenter: ChoreAdapterPresenter
    ): View.OnClickListener {

    override fun onClick(v: View?) {
        val context = v!!.context
        var view = LayoutInflater.from(context).inflate(R.layout.pop_up_new_chore, null)
        var choreName = view.popup_enter_chore_edit_id
        var assignedBy = view.popup_assigned_by_edit_id
        var assignedTo = view.popup_assigned_to_edit_id
        var saveButton = view.popup_save_chore_button_id

        var dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context).setView(view)
        var dialog: AlertDialog = dialogBuilder.create()
        dialog.show()

        saveButton.setOnClickListener {
            chore.choreName = choreName.text.toString()
            chore.assignedBy = assignedBy.text.toString()
            chore.assignedTo = assignedTo.text.toString()
            presenter!!.updateChore(chore)
            dialog.dismiss()
        }
    }
}