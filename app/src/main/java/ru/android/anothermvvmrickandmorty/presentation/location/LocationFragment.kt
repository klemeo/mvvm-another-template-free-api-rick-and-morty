package ru.android.anothermvvmrickandmorty.presentation.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ru.android.anothermvvmrickandmorty.R
import ru.android.anothermvvmrickandmorty.databinding.FragmentLocationBinding

class LocationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentLocationBinding>(
            inflater,
            R.layout.fragment_location,
            container,
            false
        )
        return binding.root
    }

}