package com.example.myapplication.about

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication.databinding.FragmentAboutBinding
import kotlinx.android.synthetic.main.fragment_about.*


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