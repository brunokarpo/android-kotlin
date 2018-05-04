package com.example.bruno.choreapp.data

import com.example.bruno.choreapp.model.Chore

interface ChoreRepository {

    fun createChore(chore: Chore)
    fun readAChore(id: Int): Chore?
    fun updateChore(chore: Chore): Int
    fun deleteChore(chore: Chore)
    fun getChoresCount(): Int
    fun readChores(): ArrayList<Chore>
}