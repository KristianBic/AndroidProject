package com.example.android.navigation
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * Fragment sa zobrazi iba pri prvom spusteni aplikacie.
 * Sluzi na strucny opis aplikacie a privitanie pouzivatela
 */
class IntroductionWelcomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        //Inicializacia bindingu
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title,container,false)

        //presunutie na fragment gameFragment po stlaceni tlacidla
        binding.getStarted.setOnClickListener{view : View -> view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)}
        return binding.root
    }
}