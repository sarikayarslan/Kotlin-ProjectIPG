package com.arslan.pillapp
import android.database.sqlite.SQLiteDatabase


class TableAlarm(db: SQLiteDatabase) :DBTable(db,NAME){
    override fun create(){
        db.execSQL("CREATE TABLE IF NOT EXISTS alarm(id INTEGER PRIMARY KEY,alarmTime DateTime NOT NULL, pillID INTEGER NOT NULL, FOREIGN KEY(pillID) REFERENCES pill(id))")
    }


    companion object{
        const val NAME = "pills"
    }

}