package ru.android.anothermvvmrickandmorty.presentation.episode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ru.android.anothermvvmrickandmorty.R
import ru.android.anothermvvmrickandmorty.databinding.FragmentEpisodeBinding

class EpisodeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentEpisodeBinding>(
            inflater,
            R.layout.fragment_episode,
            container,
            false
        )
        return binding.root
    }

}