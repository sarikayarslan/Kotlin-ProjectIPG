package com.arslan.pillapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try{
            val database =this.openOrCreateDatabase("database", Context.MODE_PRIVATE,null)
            database.execSQL("CREATE TABLE IF NOT EXISTS pill(id INTEGER PRIMARY KEY,name VARCHAR,miligram FLOAT, photoPath VARCHAR)")
            database.execSQL("CREATE TABLE IF NOT EXISTS description(id INTEGER PRIMARY KEY, description VARCHAR , FOREIGN KEY(id) REFERENCES pill(id)) ")
            database.execSQL("CREATE TABLE IF NOT EXISTS alarm(id INTEGER PRIMARY KEY,alarmTime DateTime , FOREIGN KEY(id) REFERENCES pill(id))")




        }catch (e : Exception){
            e.printStackTrace()
        }

    }
}