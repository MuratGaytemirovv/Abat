package com.weeprogram.abat.screens.words

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.weeprogram.abat.R
import com.weeprogram.abat.database.Word
import com.weeprogram.abat.databinding.WordItemBinding

class WordAdapter(val clickListener: WordListener) : ListAdapter<Word, WordAdapter.ViewHolder>(WordDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item!!, clickListener)


    }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: WordItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Word, clickListener: WordListener) {
            binding.word = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = WordItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}


class WordDiffCallback : DiffUtil.ItemCallback<Word>() {

    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.wordId == newItem.wordId
    }


    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem == newItem
    }


}

class WordListener(val clickListener: (wordId: Int) -> Unit) {
    fun onClick(word: Word) = clickListener(word.wordId)
}