package com.safetrained.myapplication.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.safetrained.myapplication.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAboutBinding.inflate(inflater, container, false)
            .apply {
                executePendingBindings()
                toolbar.setNavigationOnClickListener { view ->
                    view.findNavController().navigateUp()
                }

            }
//        binding.aboutText.setMovementMethod(LinkMovementMethod.getInstance());

        return binding.root
    }

}