package ru.android.anothermvvmrickandmorty.base

import android.os.Bundle
import androidx.fragment.app.Fragment

inline fun <T : Fragment> T.args(builder: Bundle.() -> Unit): T {
    arguments = arguments ?: Bundle()
        .apply(builder)
    return this
}