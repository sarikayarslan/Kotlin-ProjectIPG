package com.arslan.pillapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Alarm(
    @PrimaryKey(autoGenerate = false)
    val alarmId: String,
    val alarmName: String,
)