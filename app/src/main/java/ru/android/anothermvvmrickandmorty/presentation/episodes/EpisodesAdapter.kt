package ru.android.anothermvvmrickandmorty.presentation.episodes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.android.anothermvvmrickandmorty.databinding.ItemEpisodeBinding
import ru.android.anothermvvmrickandmorty.domain.models.episode_body.EpisodeResult

private const val ITEM_VIEW_TYPE_ITEM = 0

class EpisodesAdapter(val clickListener: EpisodesListener) : ListAdapter<DataItem,
        RecyclerView.ViewHolder>(EpisodesDiffCallback()) {

    private val adapterScope = CoroutineScope(Dispatchers.Default)

    fun addHeaderAndSubmitList(list: List<EpisodeResult>) {
        adapterScope.launch {
            val items = list.map { DataItem.EpisodeItem(it) }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val item = getItem(position) as DataItem.EpisodeItem
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
            is DataItem.EpisodeItem -> ITEM_VIEW_TYPE_ITEM
            else -> throw ClassCastException("Unknown ItemViewType ${getItem(position)}")
        }
    }

    class ViewHolder private constructor(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: EpisodesListener, item: EpisodeResult) {
            binding.data = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemEpisodeBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class EpisodesDiffCallback : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.episodeResult == newItem.episodeResult
    }

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }
}

class EpisodesListener(val clickListener: (data: EpisodeResult) -> Unit) {
    fun onClick(data: EpisodeResult) = clickListener(data)
}

sealed class DataItem {
    data class EpisodeItem(val data: EpisodeResult) : DataItem() {
        override val episodeResult = data
    }

    abstract val episodeResult: EpisodeResult
}