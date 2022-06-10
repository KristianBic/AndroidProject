package com.example.android.navigation
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameWonBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * Hlavny fragment, s ktorym pouzivatel pracuje.
 * Pouzivatel tu ma znazornene vsetky aktivity, ktore chce zlepsit
 */
class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        //Inicializacia bindingu
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_won, container, false)

        //zmena formatu datumu na dd.mmmm.yyyy - napr. 10 júna 2022 pre obj. TasksDate
        binding.TasksDate.text = SimpleDateFormat("dd MMMM yyyy").format(Date())

        //navigacny bar na spodu obrazovky
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.today->view?.findNavController()?.navigate(R.id.gameWonFragment)
                R.id.progress->view?.findNavController()?.navigate(R.id.action_gameWonFragment_to_gameOverFragment)
                R.id.settings->view?.findNavController()?.navigate(R.id.action_gameWonFragment_to_aboutFragment)
            }
            true
        }
        return binding.root
    }
}
