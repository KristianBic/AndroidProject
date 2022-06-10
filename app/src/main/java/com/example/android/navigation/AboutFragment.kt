

package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentAboutBinding
import com.example.android.navigation.databinding.FragmentGameOverBinding
import java.text.SimpleDateFormat
import java.util.*

class AboutFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentAboutBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_about, container, false)

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
