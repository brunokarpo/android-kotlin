package com.example.bruno.choreapp.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.bruno.choreapp.model.*
import java.text.DateFormat
import java.util.*

class ChoresDatabaseHandler(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION),
        ChoreRepository{

    override fun onCreate(db: SQLiteDatabase?) {
        // SQL = Structured Query Language
        var create_chore_table = QUERY_CREATE_CHORE_TABLE

        db?.execSQL(create_chore_table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL(QUERY_DROP_CHORE_TABLE)

        onCreate(db)
    }

    /*
     * CRUD - Create, Read, Update, Delete
     */

    override fun createChore(chore: Chore) {
        var db: SQLiteDatabase = writableDatabase

        var values: ContentValues = ContentValues()
        values.put(KEY_CHORE_NAME, chore.choreName)
        values.put(KEY_CHORE_ASSIGNED_BY, chore.assignedBy)
        values.put(KEY_CHORE_ASSIGNED_TO, chore.assignedTo)
        values.put(KEY_CHORE_ASSIGNED_TIME, System.currentTimeMillis())

        db.insert(TABLE_NAME, null, values)

        Log.d("DATA INSERTED", "SUCESS")
        db.close()
    }

    override fun readAChore(id: Int): Chore? {
        var db: SQLiteDatabase = readableDatabase
        val columns = arrayOf(KEY_ID,
                KEY_CHORE_NAME, KEY_CHORE_ASSIGNED_TO, KEY_CHORE_ASSIGNED_BY,
                KEY_CHORE_ASSIGNED_TIME)
        val selection = KEY_ID + "=?"
        val parameters = arrayOf(id.toString())

        var cursor: Cursor = db.query(TABLE_NAME, columns, selection, parameters, null, null, null)

        if (cursor.moveToFirst().not()) {
            return null
        }

        cursor.moveToFirst()

        var chore = Chore()
        chore.id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
        chore.choreName = cursor.getString(cursor.getColumnIndex(KEY_CHORE_NAME))
        chore.assignedBy = cursor.getString(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_BY))
        chore.assignedTo = cursor.getString(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_TO))

        var timeAssigned = cursor.getLong(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_TIME))
        chore.timeAssigned = timeAssigned

        var dateFormat: java.text.DateFormat = DateFormat.getDateInstance()
        var formattedDate = dateFormat.format(Date(chore.timeAssigned!!).time)

        return chore
    }


    override fun updateChore(chore: Chore): Int {
        var db: SQLiteDatabase = writableDatabase

        var values = ContentValues()
        values.put(KEY_CHORE_NAME, chore.choreName)
        values.put(KEY_CHORE_ASSIGNED_BY, chore.assignedBy)
        values.put(KEY_CHORE_ASSIGNED_TO, chore.assignedTo)
        values.put(KEY_CHORE_ASSIGNED_TIME, System.currentTimeMillis())

        val whereClause = "$KEY_ID =?"

        val update = db.update(TABLE_NAME, values, whereClause, arrayOf(chore.id.toString()))
        db.close()

        return update
    }


    override fun deleteChore(chore: Chore) {
        var db: SQLiteDatabase = writableDatabase

        val whereClause = "$KEY_ID = ?"
        db.delete(TABLE_NAME, whereClause, arrayOf(chore.id.toString()))
        db.close()
    }

    override fun getChoresCount(): Int {

        var db = readableDatabase

        var countQuery = QUERY_COUNT_CHORE
        var cursor: Cursor = db.rawQuery(countQuery, null)

        return cursor.getInt(1)

    }
}