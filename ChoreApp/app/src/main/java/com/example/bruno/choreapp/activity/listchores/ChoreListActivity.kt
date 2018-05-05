package com.example.bruno.choreapp.activity.listchores

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.bruno.choreapp.R
import com.example.bruno.choreapp.activity.createchore.MainActivity
import com.example.bruno.choreapp.data.ChoreRepository
import com.example.bruno.choreapp.data.ChoresDatabaseHandler
import com.example.bruno.choreapp.model.Chore
import kotlinx.android.synthetic.main.activity_chore_list.*
import kotlinx.android.synthetic.main.pop_up_new_chore.view.*

class ChoreListActivity : AppCompatActivity(), ListChoreView {

    private var presenter: ListChorePresenter? = null

    private var choreRepository: ChoreRepository? = null

    private var dialog: AlertDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chore_list)

        choreRepository = ChoresDatabaseHandler(this)
        presenter = ListChorePresenterImpl(this, choreRepository!!)

        presenter!!.retrieveAllChores()
    }

    override fun showChoreList(listChores: ArrayList<Chore>) {
        var layoutManager = LinearLayoutManager(this)
        var adapter = ChoreListAdapter(listChores, this)

        list_chores_recycler_view_id.layoutManager = layoutManager
        list_chores_recycler_view_id.adapter = adapter

        adapter.notifyDataSetChanged()
    }

    override fun goToNewChoreActivity() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            R.id.menu_add_chore_button_id -> {
                showPopUpNewChore()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun showPopUpNewChore() {
        var view = layoutInflater.inflate(R.layout.pop_up_new_chore, null)
        var choreName = view.popup_enter_chore_edit_id
        var assignedBy = view.popup_assigned_by_edit_id
        var assignedTo = view.popup_assigned_to_edit_id
        var saveButton = view.popup_save_chore_button_id

        var dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this).setView(view)
        dialog = dialogBuilder.create()
        dialog!!.show()

        saveButton.setOnClickListener {
            presenter!!.createChore(choreName.text.toString(), assignedBy.text.toString(),
                    assignedTo.text.toString())
        }
    }

    override fun dismissPopUpNewChore() {
        dialog!!.dismiss()
    }

    override fun reloadList() {
        presenter!!.retrieveAllChores()
    }
}
