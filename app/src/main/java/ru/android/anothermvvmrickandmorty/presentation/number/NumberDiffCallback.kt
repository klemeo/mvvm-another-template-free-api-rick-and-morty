package ru.android.anothermvvmrickandmorty.presentation.number

import androidx.recyclerview.widget.DiffUtil

class NumberDiffCallback : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.numberResult == newItem.numberResult
    }

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }
}