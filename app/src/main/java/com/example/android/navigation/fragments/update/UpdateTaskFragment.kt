package com.example.android.navigation.fragments.update
import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.android.navigation.R
import com.example.android.navigation.database.model.Tasks
import com.example.android.navigation.database.viewmodel.TasksViewModel
import kotlinx.android.synthetic.main.fragment_update_task.*
import kotlinx.android.synthetic.main.fragment_update_task.view.*

class UpdateTaskFragment : Fragment() {

    private val args by navArgs<UpdateTaskFragmentArgs>()
    private lateinit var mTasksViewModel : TasksViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_update_task, container, false)

        //Inicializacia ViewModelu
        mTasksViewModel = ViewModelProvider(this).get(TasksViewModel::class.java)

        view.updateTaskName.setText(args.currentTask.taskName)
        view.updateTaskType.setText(args.currentTask.timeType)

        view.update_btn.setOnClickListener {
            updateDataFromDatabase()
        }
        view.floatingDeleteButton.setOnClickListener {
            deleteDataFromDatabase()
        }
        return view
    }

    private fun updateDataFromDatabase() {
        val taskName = updateTaskName.text.toString()
        val taskType = updateTaskType.text.toString()
        if (inputCheck(taskName, taskType)) {
            val updatedTask = Tasks(0, taskName, taskType)
            mTasksViewModel.updateTask(updatedTask)
            Toast.makeText(requireContext(), "Successful", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateTaskFragment_to_settingsTaskFragment)
        } else {
            Toast.makeText(requireContext(), "Fill all fields", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(taskName : String, taskType : String): Boolean {
        return !(TextUtils.isEmpty(taskName) && TextUtils.isEmpty(taskType))
    }

    private fun deleteDataFromDatabase() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            mTasksViewModel.deleteTask(args.currentTask)
            Toast.makeText(requireContext(), "Removed: ${args.currentTask.taskName}", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateTaskFragment_to_settingsTaskFragment)
        }
        builder.setNegativeButton("No"){_,_ -> }
        builder.setTitle("Delete ${args.currentTask.taskName}?")
        builder.setMessage("Are you sure you want to delete ${args.currentTask.taskName}?")
        builder.create().show()
    }
}