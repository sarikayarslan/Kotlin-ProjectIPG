package com.arslan.pillapp
import android.database.sqlite.SQLiteDatabase


class TablePill(db: SQLiteDatabase) :DBTable(db,NAME){
    override fun create(){
        db.execSQL("CREATE TABLE IF NOT EXISTS $name(id INTEGER PRIMARY KEY,name VARCHAR NOT NULL,count FLOAT NOT NULL, description VARCHAR)")}


    companion object{
        const val NAME = "pills"
    }

}