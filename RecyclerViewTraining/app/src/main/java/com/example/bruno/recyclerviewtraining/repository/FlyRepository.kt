package com.example.bruno.recyclerviewtraining.repository

import com.example.bruno.recyclerviewtraining.model.Fly

class FlyRepository {

    private var flies: MutableList<Fly>? = null

    private constructor() {

        flies = mutableListOf<Fly>(
                Fly("Gol", "Goiania", "Brasilia"),
                Fly("Azul", "São Paulo", "Sergipe"),
                Fly("Tam", "Rio Branco", "Porto Alegre")
        )

    }

    companion object {
        val instance = FlyRepository()
    }

    fun retriveAll(): ArrayList<Fly> {
        return ArrayList(flies)
    }

}