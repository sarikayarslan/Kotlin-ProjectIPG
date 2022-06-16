package com.arslan.pillapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pill(
    @PrimaryKey(autoGenerate = false)
    val pillName: String,
    val Description: String,
    val Count: String


)