package com.example.android.navigation.database.repository
import androidx.lifecycle.LiveData
import com.example.android.navigation.database.AppDatabaseDao
import com.example.android.navigation.database.model.Tasks

/**
 * Repository pre tabulku Tasks
 * Repository je trieda, ktora abstraktuje pristup ku viacerym datovym zdrojom
 * Nie je potrebna ale je to - a good practise
 */
class TasksRepository(private val appDatabaseDao : AppDatabaseDao) {

    val readAllData : LiveData<List<Tasks>> = appDatabaseDao.readAllData()

    fun addTask(tasks: Tasks) {
        appDatabaseDao.addTask(tasks)
    }

    fun updateTask(tasks: Tasks) {
        appDatabaseDao.updateTask(tasks)
    }
}