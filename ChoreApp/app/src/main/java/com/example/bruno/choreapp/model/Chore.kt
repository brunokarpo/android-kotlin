package com.example.bruno.choreapp.model

import java.text.DateFormat
import java.util.*

class Chore(
        var choreName: String? = null,
        var assignedBy: String? = null,
        var assignedTo: String? = null,
        var timeAssigned: Long? = null,
        var id: Int? = null
    ) {

    fun showHumanDate(): String {
        var dateFormat: java.text.DateFormat = DateFormat.getDateInstance()
        var formattedDate: String = dateFormat.format(Date(timeAssigned!!).time)

        return "Created $formattedDate"
    }
}