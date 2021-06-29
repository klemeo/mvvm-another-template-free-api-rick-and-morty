package ru.android.anothermvvmrickandmorty.presentation.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.android.anothermvvmrickandmorty.databinding.ItemNumberBinding
import ru.android.anothermvvmrickandmorty.presentation.number.DataItem
import ru.android.anothermvvmrickandmorty.presentation.number.NumberDiffCallback
import ru.android.anothermvvmrickandmorty.presentation.number.NumberListener
import ru.android.anothermvvmrickandmorty.presentation.utils.pageCharacter

private const val ITEM_VIEW_TYPE_ITEM = 0

class LocationAdapter (val clickListener: NumberListener) : ListAdapter<DataItem,
        RecyclerView.ViewHolder>(NumberDiffCallback()) {

    private val adapterScope = CoroutineScope(Dispatchers.Default)

    fun addHeaderAndSubmitList(list: List<String>) {
        adapterScope.launch {
            val items = list.map { DataItem.NumberItem(it) }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val item = getItem(position) as DataItem.NumberItem
                holder.bind(clickListener, item.data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_ITEM -> ViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.NumberItem -> ITEM_VIEW_TYPE_ITEM
            else -> throw ClassCastException("Unknown ItemViewType ${getItem(position)}")
        }
    }

    class ViewHolder private constructor(private val binding: ItemNumberBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: NumberListener, item: String) {
            binding.data = item.pageCharacter().toString()
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNumberBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}