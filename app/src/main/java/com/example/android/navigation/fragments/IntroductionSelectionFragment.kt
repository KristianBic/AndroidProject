package com.example.android.navigation.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.android.navigation.R
import com.example.android.navigation.database.model.Tasks
import com.example.android.navigation.database.viewmodel.TasksViewModel
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
    private lateinit var mTasksViewModel : TasksViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        //Inicializacia bindingu
        val binding = DataBindingUtil.inflate<FragmentIntroductionSelectionBinding>(inflater,
            R.layout.fragment_introduction_selection, container, false)

        //Inicializacia ViewModelu
        mTasksViewModel = ViewModelProvider(this).get(TasksViewModel::class.java)

        meditation = binding.firstAnswerRadioButton
        training = binding.secondAnswerRadioButton
        walking = binding.thirdAnswerRadioButton
        sleep = binding.fourthAnswerRadioButton

        //pridanie do listu prvky, ktore si pouzivatel vybral
        binding.welcomeImproveNext.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            if (meditation.isChecked) {
                Toast.makeText(requireContext(), "meditation", Toast.LENGTH_LONG).show()
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
            insertDataToDatabase()
            view.findNavController().navigate(R.id.action_introductionSelectionFragment_to_homeFragment)
        }
        return binding.root
    }
    private fun insertDataToDatabase() {
        //pridanie tasku do databazy
        val task = Tasks(0, "sleep", "sleep")
        mTasksViewModel.addTask(task)
        //Toast.makeText(requireContext(), "Successful", Toast.LENGTH_LONG).show()
    }
}
