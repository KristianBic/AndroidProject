package com.example.android.navigation.database
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AppDatabaseDao {

    @Insert
    suspend fun insert(tasks: Tasks)

    @Update
    suspend  fun update(tasks: Tasks)

    @Query("SELECT * from tasks_table WHERE taskId = :key")
    suspend fun get(key: Long): Tasks?

    @Query("DELETE FROM tasks_table")
    suspend fun clear()
}
