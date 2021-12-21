package com.weeprogram.abat.screens.words

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.weeprogram.abat.R
import com.weeprogram.abat.database.AbatDatabase
import com.weeprogram.abat.databinding.FragmentAlphabetBinding
import com.weeprogram.abat.databinding.FragmentWordBinding
import com.weeprogram.abat.screens.alphabet.AlphabetAdapter
import com.weeprogram.abat.screens.alphabet.AlphabetViewModel
import com.weeprogram.abat.screens.alphabet.AlphabetViewModelFactory
import com.google.android.material.snackbar.Snackbar
import android.content.DialogInterface
import android.text.InputType

import android.widget.EditText


class WordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWordBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_word, container, false
        )

        val snackbar: Snackbar = Snackbar
            .make(
                binding.recycleViewWords,
                "If you would like to use your own words, press the box that contains a word..",
                Snackbar.LENGTH_INDEFINITE
            )

        snackbar.show()

        val application = requireNotNull(this.activity).application
        val dataSource = AbatDatabase.getInstance(application).wordDAO
        val viewModelFactory = WordViewModelFactory(dataSource, application)

        val wordViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(WordViewModel::class.java)
        binding.wordViewModel = wordViewModel

        val adapter = WordAdapter(WordListener {

            wordViewModel.onWordClicked(it)
        })

        binding.recycleViewWords.adapter = adapter



        wordViewModel.words.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }

        })

        wordViewModel.showAlertDialog.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Please fill in your word..")


                val input = EditText(context)
                input.inputType = InputType.TYPE_CLASS_TEXT

                builder.setView(input)
                builder.setPositiveButton("OK",
                    DialogInterface.OnClickListener() { dialog, which ->
                        val newWord = input.text.toString()
                        wordViewModel.onClickOk(newWord)
                    })
                builder.setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
                builder.show()
            }
        })
        binding.lifecycleOwner = this

        return binding.root
    }

}