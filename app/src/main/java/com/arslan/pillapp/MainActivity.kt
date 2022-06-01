package com.arslan.pillapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try{
            val database =this.openOrCreateDatabase("pill", Context.MODE_PRIVATE,null)
            database.execSQL("CREATE TABLE IF NOT EXISTS pill(id INTEGER PRIMARY KEY,name VARCHAR)")



        }catch (e : Exception){
            e.printStackTrace()
        }

    }
}