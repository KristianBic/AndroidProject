package com.example.android.navigation.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentStatisticsBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * Pouzivatel tu ma znazornenu statistiku vsetkych zaznamenanych aktivit v urcitom casovom pasme
 */
class StatisticsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        //Inicializacia bindingu
        val binding = DataBindingUtil.inflate<FragmentStatisticsBinding>(inflater,
            R.layout.fragment_statistics,container,false)

        //zmena formatu datumu na mmmm.yyyy - napr. júna 2022 pre obj. TasksDate
        binding.TasksDate.text = SimpleDateFormat("MMMM yyyy").format(Date())

        //navigacny bar na spodu obrazovky
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.today ->view?.findNavController()?.navigate(R.id.action_statisticsFragment_to_homeFragment)
                R.id.progress ->view?.findNavController()?.navigate(R.id.statisticsFragment)
                R.id.settings ->view?.findNavController()?.navigate(R.id.action_statisticsFragment_to_settingsFragment)
            }
            true
        }
        return binding.root
    }
}
