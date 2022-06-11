package com.example.android.navigation.database
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tasks_table")
data class Tasks(
    @PrimaryKey(autoGenerate = true)
    val taskId: Int,

    @ColumnInfo(name = "task_name")
    val taskName: String,

    @ColumnInfo(name = "time_type")
    val timeType: String,
)

