package com.weeprogram.abat.screens.webservice

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.core.view.marginTop
import androidx.databinding.BindingAdapter
import com.weeprogram.abat.R

@BindingAdapter("languageApiStatus")
fun bindStatus(
    statusImageView: ImageView,
    status: LanguageApiStatus?
) {

    when (status) {
        LanguageApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        LanguageApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }

        LanguageApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }

    }


}

@BindingAdapter("changeColor")
fun setColor(textView: TextView, status: LanguageApiStatus?) {
    when (status) {
        LanguageApiStatus.ERROR -> {
            textView.setTextColor(Color.RED)
            textView.setBackgroundColor(Color.parseColor("#80FEFFCB"))

        }
    }
}

@BindingAdapter("textHidden")
fun hideText(textView: TextView, status: LanguageApiStatus?) {
    when (status) {
        LanguageApiStatus.ERROR -> {
            textView.isVisible = false
        }
    }
}