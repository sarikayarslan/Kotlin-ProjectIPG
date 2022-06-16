package com.arslan.pillapp


import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.arslan.pillapp.entities.Alarm
import com.arslan.pillapp.entities.Pill
import com.arslan.pillapp.entities.relations.PillAlarmCrossRef
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        pillPageButton.setOnClickListener{
            Toast.makeText(this,"İlaç butonuna basıldı",Toast.LENGTH_SHORT).show()
        }
        alarmPageButton.setOnClickListener{
            Toast.makeText(this,"Alarm butonuna basıldı",Toast.LENGTH_SHORT).show()
        }







        val dao = AppDatabase.getInstance(this).appDao



        val pills= mutableListOf(
            Pill("vermidon","Aspirin","1"),
            Pill("deneme2","denem2","2"),
            Pill("deneme3","deneme3","3"),
        )
        val alarms= mutableListOf(
            Alarm("Alarm1"),
            Alarm("Alarm2"),
            Alarm("Alarm3"),
        )

        val pillAlarmRelations = mutableListOf(
            PillAlarmCrossRef("Aspirin","Alarm1"),
            PillAlarmCrossRef("Aspirin","Alarm2"),

        )

        addButtonPill.setOnClickListener{
            pills.add(Pill(textPillName.text.toString(),textDescription.text.toString(),textPillCount.text.toString()))

            lifecycleScope.launch {
                pills.forEach { dao.insertPill(it) }
            }
        }


     //   lifecycleScope.launch {
     //       alarms.forEach { dao.insertAlarm(it) }
     //      pills.forEach { dao.insertPill(it) }
     //       pillAlarmRelations.forEach { dao.insertPillAlarmCrossRef(it) }
     //   }

    }




}