package com.example.myapplication.ui.language

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLanguageBinding
import com.example.myapplication.databinding.FragmentSettingsBinding
import com.example.myapplication.ui.settings.SettingsFragmentDirections

class LanguageFragment : Fragment()  {
//    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLanguageBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_language, container, false
        )

        return binding.root
    }
}