package ru.android.anothermvvmrickandmorty.presentation.episode

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_episode.*
import ru.android.anothermvvmrickandmorty.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.android.anothermvvmrickandmorty.base.FragmentListenerUtils
import ru.android.anothermvvmrickandmorty.databinding.FragmentEpisodeBinding
import ru.android.anothermvvmrickandmorty.presentation.CharacterScreenTwo
import ru.android.anothermvvmrickandmorty.presentation.number.NumberListener

class EpisodeFragment : Fragment() {

    private val viewModel: EpisodeViewModel by viewModel()

    private lateinit var characterListener: CharacterScreenTwo

    private val navArgs by navArgs<EpisodeFragmentArgs>()

    private val characterAdapter = CharacterAdapter(NumberListener {
        characterListener.openCharacterScreenTwo(it.toInt())
    })

    override fun onAttach(context: Context) {
        super.onAttach(context)
        characterListener =
            FragmentListenerUtils.getFragmentListener(this, CharacterScreenTwo::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentEpisodeBinding>(
        inflater,
        R.layout.fragment_episode,
        container,
        false
    ).apply {
        viewModel = this@EpisodeFragment.viewModel
        lifecycleOwner = viewLifecycleOwner

    }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        viewModel.getEpisode(navArgs.id)

        with(recyclerView) {
            val manager = GridLayoutManager(activity, 5)
            layoutManager = manager
            adapter = characterAdapter
        }

        buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }

    }

    private fun observeViewModel() {
        viewModel.episode.observe(viewLifecycleOwner, {
            if (it != null) {
                it.characters?.let { characterList -> characterAdapter.addHeaderAndSubmitList(characterList) }
                pbPost.isGone = true
            }
        })
    }

}