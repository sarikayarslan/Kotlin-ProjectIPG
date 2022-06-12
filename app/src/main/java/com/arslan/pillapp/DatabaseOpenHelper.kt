package com.arslan.pillapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseOpenHelper(context: Context) :SQLiteOpenHelper(context,NAME,null, VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        requireNotNull(db)
        TablePill(db).create()


    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {


    }

    companion object{
        const val NAME ="pillApp.db"
        private const val VERSION =1
    }

}