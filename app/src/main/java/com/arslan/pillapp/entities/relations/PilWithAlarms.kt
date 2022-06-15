package com.arslan.pillapp.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.arslan.pillapp.entities.Alarm
import com.arslan.pillapp.entities.Pill


data class PillWithAlarms (
    @Embedded val pill: Pill,
    @Relation(
        parentColumn = "pillName",
        entityColumn = "alarmName",
        associateBy = Junction(PillAlarmCrossRef::class)
    )
    val alarms: List<Alarm>
)