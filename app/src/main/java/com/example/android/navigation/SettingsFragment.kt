package com.example.android.navigation
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentAboutBinding

/**
 * Pouzivatel tu ma moznost nastavit rozne aspekty aplikacie
 */
class SettingsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        //Inicializacia bindingu
        val binding: FragmentAboutBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)

        //navigacny bar na spodu obrazovky
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.today->view?.findNavController()?.navigate(R.id.action_aboutFragment_to_gameWonFragment)
                R.id.progress->view?.findNavController()?.navigate(R.id.action_aboutFragment_to_gameOverFragment)
                R.id.settings->view?.findNavController()?.navigate(R.id.aboutFragment)
            }
            true
        }
        return binding.root
    }
}
