package com.arslan.pillapp
import android.database.sqlite.SQLiteDatabase


class TableAlarmPill(db: SQLiteDatabase) :DBTable(db,NAME){
    override fun create(){
        db.execSQL("CREATE TABLE IF NOT EXISTS alarmpill(id INTEGER PRIMARY KEY,alarmID INTEGER NOT NULL, pillID INTEGER NOT NULL, FOREIGN KEY(pillID) REFERENCES pill(id),FOREIGN KEY(alarmID) REFERENCES alarm(id))")
    }


    companion object{
        const val NAME = "pills"
    }

}