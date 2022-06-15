package com.arslan.pillapp

import androidx.room.*
import com.arslan.pillapp.entities.Alarm
import com.arslan.pillapp.entities.Pill
import com.arslan.pillapp.entities.relations.AlarmsWithPills
import com.arslan.pillapp.entities.relations.PillAlarmCrossRef
import com.arslan.pillapp.entities.relations.PillWithAlarms


@Dao
interface AppDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPill(pill: Pill)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlarm(alarm: Alarm)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPillAlarmCrossRef(crossRef: PillAlarmCrossRef)

    @Transaction
    @Query("SELECT * FROM alarm WHERE alarmName = :alarmName")
    suspend fun getPillsOfAlarm(alarmName: String): List<AlarmsWithPills>

    @Transaction
    @Query("SELECT * FROM pill WHERE pillName = :pillName")
    suspend fun getAlarmsOfPill(pillName: String): List<PillWithAlarms>

}

