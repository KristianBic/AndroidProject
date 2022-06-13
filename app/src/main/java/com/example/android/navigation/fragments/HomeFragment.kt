package com.example.android.navigation.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.navigation.R
import com.example.android.navigation.database.viewmodel.TasksViewModel
import com.example.android.navigation.databinding.FragmentHomeBinding
import com.example.android.navigation.fragments.list.ListAdapter
import java.text.SimpleDateFormat
import java.util.*

/**
 * Hlavny fragment, s ktorym pouzivatel pracuje.
 * Pouzivatel tu ma znazornene vsetky aktivity, ktore chce zlepsit
 */
class HomeFragment : Fragment() {

    private  lateinit var mTasksViewModel : TasksViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        //Inicializacia bindingu
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
            R.layout.fragment_home,container,false)

        //zmena formatu datumu na dd.mmmm.yyyy - napr. 10 júna 2022 pre obj. TasksDate
        binding.TasksDate.text = SimpleDateFormat("dd MMMM yyyy").format(Date())

        //recyclerView
        val adapter = ListAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //Inicializacia taskViewModelu
        mTasksViewModel = ViewModelProvider(this).get(TasksViewModel::class.java)
        mTasksViewModel.readAllData.observe(viewLifecycleOwner, androidx.lifecycle.Observer { task ->
            adapter.setData(task)
        })

        //navigacny bar na spodu obrazovky
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.today ->view?.findNavController()?.navigate(R.id.homeFragment)
                R.id.progress ->view?.findNavController()?.navigate(R.id.action_homeFragment_to_statisticsFragment)
                R.id.settings ->view?.findNavController()?.navigate(R.id.action_homeFragment_to_settingsFragment)
            }
            true
        }
        return binding.root
    }
}
