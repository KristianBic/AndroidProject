package com.example.android.navigation.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TasksViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData : LiveData<List<Tasks>>
    private val repository : TasksRepository

    init {
        val appDatabaseDao = AppDatabase.getDatabase(application).appDatabaseDao()
        repository = TasksRepository(appDatabaseDao)
        readAllData = repository.readAllData
    }

    fun addTask(tasks: Tasks) {
        viewModelScope.launch (Dispatchers.IO)  {
            repository.addTask(tasks)
        }
    }
}