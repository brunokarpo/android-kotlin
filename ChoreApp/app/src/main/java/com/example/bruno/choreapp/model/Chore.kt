package com.example.bruno.choreapp.model

class Chore(
        var choreName: String? = null,
        var assignedBy: String? = null,
        var assignedTo: String? = null,
        var timeAssigned: Long? = null,
        var id: Int? = null
    ) {}