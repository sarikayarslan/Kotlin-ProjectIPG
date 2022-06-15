package com.arslan.pillapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arslan.pillapp.entities.Alarm
import com.arslan.pillapp.entities.Pill
import com.arslan.pillapp.entities.relations.PillAlarmCrossRef


@Database(
    entities = [
        Pill::class,
        Alarm::class,
        PillAlarmCrossRef::class
    ],
    version=1
)



abstract class AppDatabase: RoomDatabase(){
    abstract val appDao: AppDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context):AppDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_db"
                ).build().also {
                    INSTANCE= it
                }
            }
        }
    }
}