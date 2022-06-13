package com.example.android.navigation.fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentSettingsBinding

/**
 * Pouzivatel tu ma moznost nastavit rozne aspekty aplikacie
 */
class SettingsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        //Inicializacia bindingu
        val binding = DataBindingUtil.inflate<FragmentSettingsBinding>(inflater,
            R.layout.fragment_settings,container,false)

        binding.settingsTask.setOnClickListener{view : View -> view.findNavController().navigate(R.id.action_settingsFragment_to_settingsTaskFragment)}

        //navigacny bar na spodu obrazovky
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.today ->view?.findNavController()?.navigate(R.id.action_settingsFragment_to_homeFragment)
                R.id.progress ->view?.findNavController()?.navigate(R.id.action_settingsFragment_to_statisticsFragment)
                R.id.settings ->view?.findNavController()?.navigate(R.id.settingsFragment)
            }
            true
        }
        return binding.root
    }
}
