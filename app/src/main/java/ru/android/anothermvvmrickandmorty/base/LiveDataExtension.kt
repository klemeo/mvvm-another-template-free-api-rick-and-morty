package ru.android.anothermvvmrickandmorty.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataScope
import kotlinx.coroutines.CoroutineScope
import kotlin.experimental.ExperimentalTypeInference

@OptIn(ExperimentalTypeInference::class)
fun <T> CoroutineScope.scopedLiveData(
    @BuilderInference block: suspend LiveDataScope<T>.() -> Unit
): LiveData<T> = androidx.lifecycle.liveData(
    context = coroutineContext,
    block = block
)