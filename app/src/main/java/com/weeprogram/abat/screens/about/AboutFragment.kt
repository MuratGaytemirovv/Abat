package com.weeprogram.abat.screens.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.weeprogram.abat.databinding.FragmentAboutBinding
import com.weeprogram.abat.databinding.FragmentMainBinding
import com.weeprogram.abat.R
import com.weeprogram.abat.screens.main.MainFragmentDirections
import com.weeprogram.abat.screens.main.MainViewModel
import com.weeprogram.abat.screens.main.MainViewModelFactory


class AboutFragment : Fragment() {

    private lateinit var aboutViewModel: AboutViewModel
    private lateinit var aboutViewModelFactory: AboutViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentAboutBinding>(inflater,
            R.layout.fragment_about,container,false)

        aboutViewModelFactory = AboutViewModelFactory()
        aboutViewModel  = ViewModelProviders.of(this, aboutViewModelFactory).get(AboutViewModel::class.java)

        binding.aboutViewModel = aboutViewModel

        aboutViewModel.navigateToAlphabet.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it) {
                navigateToMoreApps()
            }
        })




        return binding.root

    }


    private fun navigateToMoreApps(){
        requireView().findNavController().navigate(AboutFragmentDirections.actionAboutFragmentToMoreAppsFragment())
        aboutViewModel.navigateToMoreAppsFinished()
    }


}