package ru.android.anothermvvmrickandmorty.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ResultObserverDelegate<T>(
    private val observer: Observer<Result<T>>
) : ReadWriteProperty<Any?, LiveData<Result<T>>?> {

    private var field: LiveData<Result<T>>? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): LiveData<Result<T>>? = field

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: LiveData<Result<T>>?) {
        field?.removeObserver(observer)
        field = value
        field?.observeForever(observer)
    }
}