package com.example.bruno.recyclerviewtraining

import com.example.bruno.recyclerviewtraining.repository.FlyRepository

class ListFliesPresenterImpl(
        private val view: ListFliesContract.ListFliesView,
        private var repository: FlyRepository? = null
    ): ListFliesContract.ListFliesPresenter {

    init {
        if (repository == null) {
            repository = FlyRepository.instance
        }
    }

    override fun retrieveFlies() {
        var flies = repository!!.retriveAll()
        view.fillFliesInList(flies)
    }


}