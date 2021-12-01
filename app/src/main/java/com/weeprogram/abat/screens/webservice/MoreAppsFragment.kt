package com.weeprogram.abat.screens.webservice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.weeprogram.abat.R


class MoreAppsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "MORE APPS"
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more_apps, container, false)

    }


}