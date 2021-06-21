package ru.android.anothermvvmrickandmorty.presentation.number

sealed class DataItem {
    data class NumberItem(val data: String) : DataItem() {
        override val numberResult = data
    }

    abstract val numberResult: String
}
