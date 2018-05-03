package com.example.bruno.choreapp.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.bruno.choreapp.model.DATABASE_NAME
import com.example.bruno.choreapp.model.DATABASE_VERSION
import com.example.bruno.choreapp.model.QUERY_CREATE_CHORE_TABLE

class ChoresDatabaseHandler(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        // SQL = Structured Query Language
        var create_chore_table = QUERY_CREATE_CHORE_TABLE

        db?.execSQL(create_chore_table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}