package com.weeprogram.abat.screens.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.weeprogram.abat.R
import com.weeprogram.abat.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainViewModelFactory: MainViewModelFactory
    private var isAnimatedAlready = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,
            R.layout.fragment_main,container,false)
        mainViewModelFactory = MainViewModelFactory()
        mainViewModel  = ViewModelProviders.of(this, mainViewModelFactory).get(MainViewModel::class.java)

        binding.mainViewModel = mainViewModel

        mainViewModel.navigateToAlphabet.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it) {
                navigateToAlphabet()
            }
        })

        makeAnimation(binding)
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun makeAnimation(binding: FragmentMainBinding) {

        if (!isAnimatedAlready) {
            val button = binding.btnStart
            button.alpha = 0f
            button.animate().alpha(1f).duration = 3000
            isAnimatedAlready = true;
        }
    }


    private fun navigateToAlphabet(){
        requireView().findNavController().navigate(MainFragmentDirections.actionMainFragmentToAlphabetFragment())
        mainViewModel.navigateToAlphabetFinished()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }
}

