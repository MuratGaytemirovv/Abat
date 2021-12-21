package com.weeprogram.abat.screens.alphabet

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColorInt
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.weeprogram.abat.R
import com.weeprogram.abat.database.AbatDatabase
import com.weeprogram.abat.databinding.FragmentAlphabetBinding
import com.weeprogram.abat.screens.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_alphabet.*


class AlphabetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentAlphabetBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_alphabet, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = AbatDatabase.getInstance(application).alphabetDAO
        val viewModelFactory = AlphabetViewModelFactory(dataSource, application)
        val alphabetViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(AlphabetViewModel::class.java)

        binding.alphabetViewModel = alphabetViewModel

        val adapter = AlphabetAdapter()

        binding.recycleViewAlphabet.adapter = adapter

        alphabetViewModel.letters.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }

        })
        binding.lifecycleOwner = this

        val manager = GridLayoutManager(activity, 4, GridLayoutManager.VERTICAL, false)
        binding.recycleViewAlphabet.layoutManager = manager

        return binding.root
    }


}