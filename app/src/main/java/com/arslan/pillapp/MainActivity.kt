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
            Pill("1","Aspirin","Agrı Kesici",1),
            Pill("2","denem2","Agrı Kesici Değil",2),
            Pill("3","deneme3","Doğum Kontrol Hapı",3),
        )

        val alarms= listOf(
            Alarm("7","Alarm1"),
            Alarm("8","Alarm2"),
            Alarm("9","Alarm3"),
        )

        val pillAlarmRelations = listOf(
            PillAlarmCrossRef("1","9"),
            PillAlarmCrossRef("3","7"),
            PillAlarmCrossRef("2","8"),
            PillAlarmCrossRef("1","7"),
            PillAlarmCrossRef("3","8"),
            PillAlarmCrossRef("3","9"),
        )

        lifecycleScope.launch {
            alarms.forEach { dao.insertAlarm(it) }
            pills.forEach { dao.insertPill(it) }
            pillAlarmRelations.forEach { dao.insertPillAlarmCrossRef(it) }
        }

    }
}