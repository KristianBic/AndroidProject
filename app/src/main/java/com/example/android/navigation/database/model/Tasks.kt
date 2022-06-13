package com.example.android.navigation.database.model
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Tabulka(entita) pre databazu - appDatabase
 * @taskId - id, ktore sa automaticky inkrementuje
 * @taksName - meno pre dany task(napr. meditation)
 * @timeType - je casovy usek, v ktorom sa dany task uskutocnuje (napr. DAY)
 */
@Parcelize
@Entity(tableName = "tasks_table")
data class Tasks(
    @PrimaryKey(autoGenerate = true)
    val taskId: Int,

    @ColumnInfo(name = "task_name")
    val taskName: String,

    @ColumnInfo(name = "time_type")
    val timeType: String,
) : Parcelable

