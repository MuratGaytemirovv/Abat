package com.weeprogram.abat.screens.webservice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.weeprogram.abat.R
import com.weeprogram.abat.databinding.FragmentMoreAboutLanguageBinding


class MoreAboutLanguageFragment : Fragment() {

    private val viewModel: MoreAboutLanguageViewModel by lazy {
        ViewModelProvider(this).get(MoreAboutLanguageViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "MORE ABOUT LANGUAGE"
        // Inflate the layout for this fragment

        val binding = FragmentMoreAboutLanguageBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root

    }


}