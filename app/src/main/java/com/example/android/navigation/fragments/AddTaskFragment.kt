package com.example.android.navigation.fragments
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.android.navigation.R
import com.example.android.navigation.database.model.Tasks
import com.example.android.navigation.database.viewmodel.TasksViewModel
import kotlinx.android.synthetic.main.fragment_add_task.*
import kotlinx.android.synthetic.main.fragment_add_task.view.*

class AddTaskFragment : Fragment() {

    private lateinit var mTasksViewModel : TasksViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_add_task, container, false)

        //Inicializacia ViewModelu
        mTasksViewModel = ViewModelProvider(this).get(TasksViewModel::class.java)

        view.add_btn.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }
    private fun insertDataToDatabase() {
        //pridanie tasku do databazy
        val taskName = addTaskName.text.toString()
        val taskType = addTaskType.text.toString()
        if (inputCheck(taskName, taskType)) {
            val task = Tasks(0, taskName, taskType)
            mTasksViewModel.addTask(task)
            Toast.makeText(requireContext(), "Successful", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addTaskFragment_to_settingsTaskFragment)
        } else {
            Toast.makeText(requireContext(), "Fill all fields", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(taskName : String, taskType : String): Boolean {
        return !(TextUtils.isEmpty(taskName) && TextUtils.isEmpty(taskType))
    }
}