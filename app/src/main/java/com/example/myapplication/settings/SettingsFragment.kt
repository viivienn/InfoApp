package com.example.myapplication.settings

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSettingsBinding
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSettingsBinding.inflate(inflater, container, false)
            .apply {
                toolbar.setNavigationOnClickListener { view ->
                    view.findNavController().navigateUp()
                }

            }
        binding.languageButton.setOnClickListener { view: View ->
            (activity as MainActivity?)?.showChangeLang()
        }

        binding.aboutButton.setOnClickListener { view: View ->
            view.findNavController().navigate(SettingsFragmentDirections.actionNavigationSettingsToAboutFragment())
        }

        binding.linkButton.setOnClickListener{view: View ->
            val uri: Uri = Uri.parse("http://www.google.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.refButton.setOnClickListener { view: View ->
            view.findNavController().navigate(SettingsFragmentDirections.actionNavigationSettingsToReferencesFragment())
        }

        return binding.root
    }
}
