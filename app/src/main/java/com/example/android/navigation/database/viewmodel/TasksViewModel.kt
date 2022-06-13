package com.example.android.navigation.database.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.android.navigation.database.AppDatabase
import com.example.android.navigation.database.repository.TasksRepository
import com.example.android.navigation.database.model.Tasks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Cez viewModel pristupujeme ku vsetkym nasim queries z DAO
 * ViewModel poskytuje data pre UI
 * ViewModel sa sprava ako komunikativne centrum medzi repository a UIl
 */
class TasksViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData : LiveData<List<Tasks>>
    private val repository : TasksRepository

    init {
        val appDatabaseDao = AppDatabase.getDatabase(application).appDatabaseDao()
        repository = TasksRepository(appDatabaseDao)
        readAllData = repository.readAllData
    }

    fun addTask(tasks: Tasks) {
        //aby to bezalo v background thread - corourines
        viewModelScope.launch (Dispatchers.IO)  {
            repository.addTask(tasks)
        }
    }

    fun updateTask(tasks: Tasks) {
        //aby to bezalo v background thread - corourines
        viewModelScope.launch (Dispatchers.IO)  {
            repository.updateTask(tasks)
        }
    }
}