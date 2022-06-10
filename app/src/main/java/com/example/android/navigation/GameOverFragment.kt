

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

class GameOverFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_over, container, false)
        binding.TasksDate.text = SimpleDateFormat("MMMM yyyy").format(Date())
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
