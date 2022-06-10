package com.example.android.navigation
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentIntroductionSelectionBinding

/**
 * Fragment sa zobrazi iba pri prvom spusteni aplikacie.
 * Na fragmente si pouzivatel vyberie, ktore veci chce zaznamenavat
 */
class IntroductionSelectionFragment : Fragment() {

    private val theList = mutableSetOf("")
    private lateinit var meditation: CheckBox
    private lateinit var training: CheckBox
    private lateinit var walking: CheckBox
    private lateinit var sleep: CheckBox

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        //Inicializacia bindingu
        val binding = DataBindingUtil.inflate<FragmentIntroductionSelectionBinding>(inflater, R.layout.fragment_introduction_selection, container, false)

        meditation = binding.firstAnswerRadioButton
        training = binding.secondAnswerRadioButton
        walking = binding.thirdAnswerRadioButton
        sleep = binding.fourthAnswerRadioButton

        //pridanie do listu prvky, ktore si pouzivatel vybral
        binding.welcomeImproveNext.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            if (meditation.isChecked) {
                theList.add("meditation")
            }
            if (training.isChecked) {
                theList.add("training")
            }
            if (walking.isChecked) {
                theList.add("walking")
            }
            if (sleep.isChecked) {
                theList.add("sleep")
            }
            view.findNavController().navigate(R.id.action_introductionSelectionFragment_to_homeFragment)
        }
        return binding.root
    }
}
