package com.arslan.pillapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.arslan.pillapp.entities.Alarm
import com.arslan.pillapp.entities.Pill
import com.arslan.pillapp.entities.relations.PillAlarmCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = AppDatabase.getInstance(this).appDao

        val pills= listOf(
            Pill("deneme","Aspirin",1),
            Pill("deneme2","denem2",2),
            Pill("deneme3","deneme3",3),
        )

        val alarms= listOf(
            Alarm("Alarm1"),
            Alarm("Alarm2"),
            Alarm("Alarm3"),
        )

        val pillAlarmRelations = listOf(
            PillAlarmCrossRef("Aspirin","Alarm1"),
            PillAlarmCrossRef("Aspirin","Alarm2"),

        )

        lifecycleScope.launch {
            alarms.forEach { dao.insertAlarm(it) }
            pills.forEach { dao.insertPill(it) }
            pillAlarmRelations.forEach { dao.insertPillAlarmCrossRef(it) }
        }

    }
}