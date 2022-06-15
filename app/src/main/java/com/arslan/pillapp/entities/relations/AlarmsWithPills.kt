package com.arslan.pillapp.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.arslan.pillapp.entities.Alarm
import com.arslan.pillapp.entities.Pill


data class AlarmsWithPills (
    @Embedded val alarm: Alarm,
    @Relation(
        parentColumn = "alarmName",
        entityColumn = "pillName",
        associateBy = Junction(PillAlarmCrossRef::class)
    )
    val alarms: List<Pill>
)