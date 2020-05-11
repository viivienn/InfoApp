package com.example.myapplication.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSettingsBinding
import com.example.myapplication.settings.SettingsFragmentDirections


class SettingsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentSettingsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_settings, container, false
        )

        binding.languageButton.setOnClickListener { view: View ->
            (activity as MainActivity?)?.showChangeLang()
        }

        binding.aboutButton.setOnClickListener { view: View ->
            view.findNavController().navigate(SettingsFragmentDirections.actionNavigationSettingsToAboutFragment())
        }
        return binding.root
    }
}
