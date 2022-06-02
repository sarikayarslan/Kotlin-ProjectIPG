package com.arslan.pillapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try{
            val database =this.openOrCreateDatabase("database", Context.MODE_PRIVATE,null)
            database.execSQL("CREATE TABLE IF NOT EXISTS pill(id INTEGER PRIMARY KEY,name VARCHAR,miligram FLOAT, photo BLOB)")
            database.execSQL("CREATE TABLE IF NOT EXISTS description(id INTEGER PRIMARY KEY, description VARCHAR ,pillID INTEGER, FOREIGN KEY(pillID) REFERENCES pill(id)) ")
            database.execSQL("CREATE TABLE IF NOT EXISTS alarm(id INTEGER PRIMARY KEY,alarmTime DateTime ,pillID INTEGER, FOREIGN KEY(pillID) REFERENCES pill(id))")



        }catch (e : Exception){
            e.printStackTrace()
        }





    }

    fun save (view: View){
        textView.text = "Merhaba"
    }
}
