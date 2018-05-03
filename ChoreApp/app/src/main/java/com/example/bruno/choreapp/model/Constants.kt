package com.example.bruno.choreapp.model

val DATABASE_VERSION: Int = 1
val DATABASE_NAME: String = "chore_db"
val TABLE_NAME: String = "chores"

val KEY_ID: String = "id"
val KEY_CHORE_NAME: String = "chore_name"
val KEY_CHORE_ASSIGNED_BY: String = "chore_assigned_by"
val KEY_CHORE_ASSIGNED_TO: String = "chore_assigned_to"
val KEY_CHORE_ASSIGNED_TIME: String = "chore_assigned_time"

val QUERY_CREATE_CHORE_TABLE: String = "CREATE TABLE $TABLE_NAME " +
        "($KEY_ID INTEGER PRIMARY KEY, " +
        "$KEY_CHORE_NAME TEXT, " +
        "$KEY_CHORE_ASSIGNED_BY TEXT," +
        "$KEY_CHORE_ASSIGNED_TO TEXT," +
        "$KEY_CHORE_ASSIGNED_TIME LONG)"

val QUERY_DROP_CHORE_TABLE: String = "DROP TABLE IF EXISTS $TABLE_NAME"
var QUERY_COUNT_CHORE: String = "SELECT COUNT(*) FROM $TABLE_NAME"