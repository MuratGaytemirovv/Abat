package com.weeprogram.abat.screens.alphabet

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.weeprogram.abat.database.Alphabet
import com.weeprogram.abat.databinding.LetterItemBinding
import com.weeprogram.abat.generated.callback.OnClickListener
import com.weeprogram.abat.R
import android.content.Context
import android.content.res.AssetFileDescriptor
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.view.SoundEffectConstants
import android.view.View
import android.view.animation.*
import androidx.test.core.app.ApplicationProvider

import androidx.test.core.app.ApplicationProvider.getApplicationContext




class AlphabetAdapter(): ListAdapter<Alphabet, AlphabetAdapter.ViewHolder>(AlphabetDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        var mediaPlayer: MediaPlayer

        holder.itemView.setOnClickListener() {
            makeAnimation(item, it)

                val resId = listOf(R.raw.s_0, R.raw.s_1, R.raw.s_2, R.raw.s_3, R.raw.s_4, R.raw.s_5, R.raw.s_6, R.raw.s_7,
                                    R.raw.s_8,R.raw.s_9,R.raw.s_10, R.raw.s_11, R.raw.s_12, R.raw.s_13, R.raw.s_14, R.raw.s_15,
                                    R.raw.s_16, R.raw.s_17, R.raw.s_18, R.raw.s_19, R.raw.s_20, R.raw.s_21, R.raw.s_22, R.raw.s_23,
                                    R.raw.s_24, R.raw.s_25, R.raw.s_26, R.raw.s_27, R.raw.s_28, R.raw.s_29, R.raw.s_30, R.raw.s_31,
                                    R.raw.s_32, R.raw.s_33, R.raw.s_34, R.raw.s_35, R.raw.s_36, R.raw.s_37, R.raw.s_38, R.raw.s_39,
                                    R.raw.s_40, R.raw.s_41, R.raw.s_42, R.raw.s_43, R.raw.s_44, R.raw.s_45)
                mediaPlayer = MediaPlayer.create(it.context, resId[position])
                mediaPlayer.start()
        }

    }

    private fun makeAnimation(item: Alphabet, it: View) {
        if (item.letterId == 0 || item.letterId % 2 == 0) {
            it.startAnimation(createAnimation())

        } else {
            it.startAnimation(createSecondAnimation())
        }
    }


    fun createSecondAnimation(): Animation? {
        val anim = AlphaAnimation(0F,1F)
        anim.interpolator = FastOutSlowInInterpolator()
        anim.duration = 3000


        return anim
    }

    fun createAnimation(): Animation? {
        val anim = RotateAnimation(0F, 360F, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        anim.interpolator = FastOutSlowInInterpolator()
        anim.duration = 3000


        return anim
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)



    }

    class ViewHolder private constructor(val binding: LetterItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Alphabet) {
            binding.letter = item

            binding.executePendingBindings()
        }





        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LetterItemBinding.inflate(layoutInflater, parent, false)


                return ViewHolder(binding)
            }


        }
    }
}


class AlphabetDiffCallback : DiffUtil.ItemCallback<Alphabet>() {

    override fun areItemsTheSame(oldItem: Alphabet, newItem: Alphabet): Boolean {
        return oldItem.letterId == newItem.letterId
    }


    override fun areContentsTheSame(oldItem: Alphabet, newItem: Alphabet): Boolean {
        return oldItem == newItem
    }

}




