package ru.android.anothermvvmrickandmorty.presentation.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_characters.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.android.anothermvvmrickandmorty.R
import ru.android.anothermvvmrickandmorty.databinding.FragmentEpisodesBinding

class EpisodesFragment : Fragment() {

    private val viewModel: EpisodesViewModel by viewModel()

    private val episodesAdapter = EpisodesAdapter(EpisodesListener {

    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentEpisodesBinding>(
        inflater,
        R.layout.fragment_episodes,
        container,
        false
    ).apply {
        viewModel = this@EpisodesFragment.viewModel
        lifecycleOwner = viewLifecycleOwner

    }
        .root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        viewModel.getEpisodes()

        with(recyclerView) {
            val manager = GridLayoutManager(activity, 1)
            layoutManager = manager
            adapter = episodesAdapter
        }

        buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }

    }

    private fun observeViewModel() {
        viewModel.episode.observe(viewLifecycleOwner, {
            if (it != null) {
                it.results?.let { results -> episodesAdapter.addHeaderAndSubmitList(results) }
                pbPost.isGone = true
                backButton.isGone = viewModel.visiblePrev()
                nextButton.isGone = viewModel.visibleNext()
            }
        })
    }

}