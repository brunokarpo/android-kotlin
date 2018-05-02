package com.example.bruno.recyclerviewtraining

import com.example.bruno.recyclerviewtraining.model.Fly

interface ListFliesContract {

    interface ListFliesView {

        fun fillFliesInList(flies: ArrayList<Fly>)

    }

    interface ListFliesPresenter {
        fun retrieveFlies()
    }
}