package ru.android.anothermvvmrickandmorty.presentation.characters

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
import ru.android.anothermvvmrickandmorty.databinding.FragmentCharactersBinding

class CharactersFragment : Fragment() {

    private val viewModel: CharactersViewModel by viewModel()

    private val charactersAdapter = CharactersAdapter(CharactersListener {

    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentCharactersBinding>(
        inflater,
        R.layout.fragment_characters,
        container,
        false
    ).apply {
        viewModel = this@CharactersFragment.viewModel
        lifecycleOwner = viewLifecycleOwner

    }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        viewModel.getCharacters()

        with(recyclerView) {
            val manager = GridLayoutManager(activity, 1)
            layoutManager = manager
            adapter = charactersAdapter
        }

        buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }

    }

    private fun observeViewModel() {
        viewModel.character.observe(viewLifecycleOwner, {
            if (it != null) {
                it.results?.let { results -> charactersAdapter.addHeaderAndSubmitList(results) }
                pbPost.isGone = true
            }
        })
    }


}