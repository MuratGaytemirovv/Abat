package com.weeprogram.abat.screens.alphabet

import android.app.Application
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import com.weeprogram.abat.database.AlphabetDAO
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation
import android.widget.TextView
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.weeprogram.abat.R
import com.weeprogram.abat.database.Alphabet

class AlphabetViewModel(dataSource: AlphabetDAO,
                        application: Application): ViewModel() {
    val database = dataSource
    val letters = database.getAllLetters()

}