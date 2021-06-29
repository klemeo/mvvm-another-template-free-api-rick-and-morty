package ru.android.anothermvvmrickandmorty.presentation.location

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_location.*
import ru.android.anothermvvmrickandmorty.R
import ru.android.anothermvvmrickandmorty.base.FragmentListenerUtils
import ru.android.anothermvvmrickandmorty.databinding.FragmentLocationBinding
import ru.android.anothermvvmrickandmorty.presentation.LocationScreenTwo
import ru.android.anothermvvmrickandmorty.presentation.number.NumberListener

class LocationFragment : Fragment() {

    private val viewModel: LocationViewModel by viewModel()

    private val navArgs by navArgs<LocationFragmentArgs>()

    private lateinit var locationListener: LocationScreenTwo

    private val locationAdapter = LocationAdapter(NumberListener {
        locationListener.openLocationScreenTwo(it.toInt())
    })

    override fun onAttach(context: Context) {
        super.onAttach(context)
        locationListener =
            FragmentListenerUtils.getFragmentListener(this, LocationScreenTwo::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentLocationBinding>(
        inflater,
        R.layout.fragment_location,
        container,
        false
    ).apply {
        viewModel = this@LocationFragment.viewModel
        lifecycleOwner = viewLifecycleOwner

    }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        viewModel.getLocation(navArgs.id)

        with(recyclerView) {
            val manager = GridLayoutManager(activity, 5)
            layoutManager = manager
            adapter = locationAdapter
        }

        buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }

    }

    private fun observeViewModel() {
        viewModel.location.observe(viewLifecycleOwner, {
            if (it != null) {
                it.residents?.let { characterList ->
                    locationAdapter.addHeaderAndSubmitList(
                        characterList
                    )
                }
                pbPost.isGone = true
            }
        })
    }


}