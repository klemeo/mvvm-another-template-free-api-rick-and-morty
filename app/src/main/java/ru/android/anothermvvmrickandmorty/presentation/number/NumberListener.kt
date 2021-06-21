package ru.android.anothermvvmrickandmorty.presentation.number

class NumberListener(val clickListener: (data: String) -> Unit) {
    fun onClick(data: String) = clickListener(data)
}