package com.arslan.pillapp.entities.relations

import androidx.room.Entity

@Entity(primaryKeys = ["pillId","alarmId"])
data class PillAlarmCrossRef (
    val pillId: String,
    val alarmId: String
)