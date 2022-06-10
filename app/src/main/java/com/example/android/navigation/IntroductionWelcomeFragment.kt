package com.example.android.navigation
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentIntroductionWelcomeBinding

/**
 * Fragment sa zobrazi iba pri prvom spusteni aplikacie.
 * Sluzi na strucny opis aplikacie a privitanie pouzivatela
 */
class IntroductionWelcomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        //Inicializacia bindingu
        val binding = DataBindingUtil.inflate<FragmentIntroductionWelcomeBinding>(inflater, R.layout.fragment_introduction_welcome,container,false)

        //presunutie na fragment introductionSelectionFragment po stlaceni tlacidla
        binding.getStarted.setOnClickListener{view : View -> view.findNavController().navigate(R.id.action_introductionWelcomeFragment_to_introductionSelectionFragment)}
        return binding.root
    }
}