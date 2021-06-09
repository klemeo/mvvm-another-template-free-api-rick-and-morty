package ru.android.anothermvvmrickandmorty.app

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import kotlinx.coroutines.ObsoleteCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CoroutinesApplication : Application(), LifecycleObserver {

    @ObsoleteCoroutinesApi
    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        startKoin {
            androidContext(this@CoroutinesApplication)
            androidLogger()
            modules(modules)
        }
    }

}