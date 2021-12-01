package com.weeprogram.abat.screens.alphabet

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.weeprogram.abat.R
import com.weeprogram.abat.R.color.customColor
import com.weeprogram.abat.database.Alphabet
import android.view.animation.Animation
import android.view.animation.TranslateAnimation

import android.view.animation.RotateAnimation
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.interpolator.view.animation.FastOutSlowInInterpolator


@BindingAdapter("letterFromAlphabet")
fun TextView.setTextColor(item: Alphabet) {
    setTextColor(if (isEvenOrZero(item)) {
        resources.getColor(customColor)
    } else {
        resources.getColor(R.color.customColor2)
    }
    )
}

private fun isEvenOrZero(item: Alphabet) =
    item.letterId == 0 || item.letterId % 2 == 0






