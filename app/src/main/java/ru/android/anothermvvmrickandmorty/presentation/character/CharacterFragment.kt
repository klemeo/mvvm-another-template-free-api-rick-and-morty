package ru.android.anothermvvmrickandmorty.presentation.character

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_character.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.android.anothermvvmrickandmorty.R
import ru.android.anothermvvmrickandmorty.base.FragmentListenerUtils
import ru.android.anothermvvmrickandmorty.databinding.FragmentCharacterBinding
import ru.android.anothermvvmrickandmorty.presentation.EpisodeScreenTwo

class CharacterFragment : Fragment() {

    private val viewModel: CharacterViewModel by viewModel()

    private lateinit var episodeListener: EpisodeScreenTwo

    private val navArgs by navArgs<CharacterFragmentArgs>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        episodeListener =
            FragmentListenerUtils.getFragmentListener(this, EpisodeScreenTwo::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentCharacterBinding>(
        inflater,
        R.layout.fragment_character,
        container,
        false
    ).apply {
        viewModel = this@CharacterFragment.viewModel
        lifecycleOwner = viewLifecycleOwner

    }
        .root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        viewModel.getCharacter(navArgs.id)

        buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }

    }

    private fun observeViewModel() {
        viewModel.character.observe(viewLifecycleOwner, {

        })
    }

}