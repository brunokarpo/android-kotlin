package com.example.bruno.choreapp.activity.createchore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bruno.choreapp.R
import com.example.bruno.choreapp.activity.listchores.ChoreListActivity
import com.example.bruno.choreapp.data.ChoreRepository
import com.example.bruno.choreapp.data.ChoresDatabaseHandler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CreateChoreView {
    private var presenter: CreateChorePresenter? = null

    private var dbHandler: ChoreRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = ChoresDatabaseHandler(this)
        presenter = CreateChorePresenterImpl(this, dbHandler!!)

        save_chore_button_id.setOnClickListener(
                SaveChoreListener(enter_chore_edit_id, assigned_by_edit_id, assign_to_edit_id, presenter!!)
        )
    }

    override fun showMessageEnterAChore() {
        Toast.makeText(this, getString(R.string.please_enter_a_chore), Toast.LENGTH_LONG).show()
    }
    override fun showMessageChoreCreatedSuccessfully() {
        Toast.makeText(this, getString(R.string.chore_created_successfully), Toast.LENGTH_LONG).show()
    }

    override fun cleanFields() {
        enter_chore_edit_id.text.clear()
        assigned_by_edit_id.text.clear()
        assign_to_edit_id.text.clear()
    }

    override fun goToChoreListActivity() {
        var intent: Intent = Intent(this, ChoreListActivity::class.java)
        startActivity(intent)
    }
}
