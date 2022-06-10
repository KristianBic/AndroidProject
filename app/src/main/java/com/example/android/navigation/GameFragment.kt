

package com.example.android.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    val theList = mutableSetOf("")
    lateinit var meditation: CheckBox
    lateinit var training: CheckBox
    lateinit var walking: CheckBox
    lateinit var sleep: CheckBox
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
                inflater, R.layout.fragment_game, container, false)
        // Bind this fragment class to the layout
       // binding.game = this


        meditation = binding.firstAnswerRadioButton
        training = binding.secondAnswerRadioButton
        walking = binding.thirdAnswerRadioButton
        sleep = binding.fourthAnswerRadioButton

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

            if (!meditation.isChecked && !training.isChecked && !walking.isChecked && !sleep.isChecked) {
                view.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment)
            } else {
                view.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment)
            }
        }
        return binding.root
    }
}
