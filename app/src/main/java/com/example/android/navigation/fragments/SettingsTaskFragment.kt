package com.example.android.navigation.fragments
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.navigation.R
import com.example.android.navigation.database.viewmodel.TasksViewModel
import com.example.android.navigation.databinding.FragmentSettingsBinding
import com.example.android.navigation.fragments.list.ListAdapter
import kotlinx.android.synthetic.main.fragment_settings_task.view.*


class SettingsTaskFragment : Fragment() {
    private  lateinit var mTasksViewModel : TasksViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_settings_task, container, false)

        //recyclerView
        val adapter = ListAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //Inicializacia taskViewModelu
        mTasksViewModel = ViewModelProvider(this).get(TasksViewModel::class.java)
        mTasksViewModel.readAllData.observe(viewLifecycleOwner, androidx.lifecycle.Observer { task ->
            adapter.setData(task)
        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_settingsTaskFragment_to_addTaskFragment)
        }
        view.floatingDeleteEveryting.setOnClickListener {
            deleteEveryDataFromDatabase()
        }
        return view
    }

    private fun deleteEveryDataFromDatabase() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            mTasksViewModel.deleteAllTask()
            Toast.makeText(requireContext(), "Removed every task", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("No"){_,_ -> }
        builder.setTitle("Are you sure you want to delete everything ?")
        builder.setMessage("If you press yes you will delete every task ?")
        builder.create().show()
    }

}