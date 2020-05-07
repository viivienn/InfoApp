package com.example.myapplication.checklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentChecklistBinding

class ChecklistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding: FragmentChecklistBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_checklist, container, false
        )
        return binding.root
    }
}