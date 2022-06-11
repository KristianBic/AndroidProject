package com.example.android.navigation.database
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AppDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTask(tasks: Tasks)

    @Query("SELECT * from tasks_table ORDER BY taskId ASC")
    fun readAllData(): LiveData<List<Tasks>>

    /*
    @Update
      fun updateTask(tasks: Tasks)

    @Query("SELECT * from tasks_table WHERE taskId = :key")
     fun getValue(key: Long): Tasks?

    @Query("DELETE FROM tasks_table")
     fun clear()

     */

}
