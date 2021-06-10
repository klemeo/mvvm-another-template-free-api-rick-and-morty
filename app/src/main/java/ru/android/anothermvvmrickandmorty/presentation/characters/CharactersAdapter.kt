package ru.android.anothermvvmrickandmorty.presentation.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.android.anothermvvmrickandmorty.databinding.ItemCharacterBinding
import ru.android.anothermvvmrickandmorty.domain.models.character_body.CharacterResult

private const val ITEM_VIEW_TYPE_ITEM = 0

class CharactersAdapter(val clickListener: CharactersListener) : ListAdapter<DataItem,
        RecyclerView.ViewHolder>(CharactersDiffCallback()) {

    private val adapterScope = CoroutineScope(Dispatchers.Default)

    fun addHeaderAndSubmitList(list: List<CharacterResult>) {
        adapterScope.launch {
            val items = list.map { DataItem.CharacterItem(it) }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val item = getItem(position) as DataItem.CharacterItem
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
            is DataItem.CharacterItem -> ITEM_VIEW_TYPE_ITEM
            else -> throw ClassCastException("Unknown ItemViewType ${getItem(position)}")
        }
    }

    class ViewHolder private constructor(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: CharactersListener, item: CharacterResult) {
            binding.data = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCharacterBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class CharactersDiffCallback : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.characterResult == newItem.characterResult
    }

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }
}

class CharactersListener(val clickListener: (data: CharacterResult) -> Unit) {
    fun onClick(data: CharacterResult) = clickListener(data)
}

sealed class DataItem {
    data class CharacterItem(val data: CharacterResult) : DataItem() {
        override val characterResult = data
    }

    abstract val characterResult: CharacterResult
}