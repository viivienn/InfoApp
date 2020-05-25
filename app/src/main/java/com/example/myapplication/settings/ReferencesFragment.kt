package com.example.myapplication.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication.databinding.FragmentReferencesBinding

class ReferencesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentReferencesBinding.inflate(inflater, container, false)
            .apply {
                executePendingBindings()
                toolbar.setNavigationOnClickListener { view ->
                    view.findNavController().navigateUp()
                }

            }

        return binding.root
    }

}