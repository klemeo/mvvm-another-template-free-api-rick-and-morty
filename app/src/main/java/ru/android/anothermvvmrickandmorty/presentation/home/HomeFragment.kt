package ru.android.anothermvvmrickandmorty.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*
import ru.android.anothermvvmrickandmorty.R
import ru.android.anothermvvmrickandmorty.base.FragmentListenerUtils
import ru.android.anothermvvmrickandmorty.databinding.FragmentHomeBinding
import ru.android.anothermvvmrickandmorty.presentation.MainActivityContract

class HomeFragment : Fragment() {

    private lateinit var homeListener: MainActivityContract

    override fun onAttach(context: Context) {
        super.onAttach(context)
        homeListener =
            FragmentListenerUtils.getFragmentListener(this, MainActivityContract::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        charactersButton.setOnClickListener {
            homeListener.openCharactersScreen()
        }
        locationsButton.setOnClickListener {
            homeListener.openLocationsScreen()
        }
        episodesButton.setOnClickListener {
            homeListener.openEpisodesScreen()
        }
    }
}