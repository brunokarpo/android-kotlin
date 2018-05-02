package com.example.bruno.recyclerviewtraining

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bruno.recyclerviewtraining.model.Fly

class MainActivity : AppCompatActivity(), ListFliesContract.ListFliesView {

    private val presenter: ListFliesContract.ListFliesPresenter = ListFliesPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.retrieveFlies()
    }

    override fun fillFliesInList(flies: ArrayList<Fly>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
