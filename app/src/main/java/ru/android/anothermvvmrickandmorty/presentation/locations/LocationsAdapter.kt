package ru.android.anothermvvmrickandmorty.presentation.locations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.android.anothermvvmrickandmorty.databinding.ItemLocationBinding
import ru.android.anothermvvmrickandmorty.domain.models.location_body.LocationResult

private const val ITEM_VIEW_TYPE_ITEM = 0

class LocationsAdapter(val clickListener: LocationsListener) : ListAdapter<DataItem,
        RecyclerView.ViewHolder>(LocationsDiffCallback()) {

    private val adapterScope = CoroutineScope(Dispatchers.Default)

    fun addHeaderAndSubmitList(list: List<LocationResult>) {
        adapterScope.launch {
            val items = list.map { DataItem.LocationItem(it) }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val item = getItem(position) as DataItem.LocationItem
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
            is DataItem.LocationItem -> ITEM_VIEW_TYPE_ITEM
            else -> throw ClassCastException("Unknown ItemViewType ${getItem(position)}")
        }
    }

    class ViewHolder private constructor(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: LocationsListener, item: LocationResult) {
            binding.data = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemLocationBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class LocationsDiffCallback : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.locationResult == newItem.locationResult
    }

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }
}

class LocationsListener(val clickListener: (data: LocationResult) -> Unit) {
    fun onClick(data: LocationResult) = clickListener(data)
}

sealed class DataItem {
    data class LocationItem(val data: LocationResult) : DataItem() {
        override val locationResult = data
    }

    abstract val locationResult: LocationResult
}