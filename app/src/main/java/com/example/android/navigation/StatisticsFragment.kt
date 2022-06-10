package com.example.android.navigation
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameOverBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * Pouzivatel tu ma znazornenu statistiku vsetkych zaznamenanych aktivit v urcitom casovom pasme
 */
class StatisticsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        //Inicializacia bindingu
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_over, container, false)

        //zmena formatu datumu na dd.mmmm.yyyy - napr. 10 júna 2022 pre obj. TasksDate
        binding.TasksDate.text = SimpleDateFormat("MMMM yyyy").format(Date())

        //navigacny bar na spodu obrazovky
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.today->view?.findNavController()?.navigate(R.id.action_gameOverFragment_to_gameWonFragment)
                R.id.progress->view?.findNavController()?.navigate(R.id.gameOverFragment)
                R.id.settings->view?.findNavController()?.navigate(R.id.action_gameOverFragment_to_aboutFragment)
            }
            true
        }
        return binding.root
    }
}
