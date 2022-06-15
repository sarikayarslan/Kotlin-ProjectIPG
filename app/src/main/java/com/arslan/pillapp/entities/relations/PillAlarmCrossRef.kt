package com.arslan.pillapp.entities.relations

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.reflect.Constructor

@Entity(primaryKeys = ["pillName","alarmName"])
data class PillAlarmCrossRef (
    val pillName: String,
    val alarmName: String


)