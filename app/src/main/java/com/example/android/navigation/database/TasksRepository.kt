package com.example.android.navigation.database

import androidx.lifecycle.LiveData

class TasksRepository(private val appDatabaseDao : AppDatabaseDao) {

    val readAllData : LiveData<List<Tasks>> = appDatabaseDao.readAllData()

    fun addTask(tasks: Tasks) {
        appDatabaseDao.addTask(tasks)
    }
}