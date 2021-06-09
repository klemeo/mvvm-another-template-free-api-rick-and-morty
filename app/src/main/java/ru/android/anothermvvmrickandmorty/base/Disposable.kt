package ru.android.anothermvvmrickandmorty.base

interface Disposable {
    /**
     * Cancel running jobs.
     */
    fun dispose()
}