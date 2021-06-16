package ru.android.anothermvvmrickandmorty.presentation.locations

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_locations.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.android.anothermvvmrickandmorty.R
import ru.android.anothermvvmrickandmorty.base.FragmentListenerUtils
import ru.android.anothermvvmrickandmorty.databinding.FragmentLocationsBinding
import ru.android.anothermvvmrickandmorty.presentation.LocationScreenOne

class LocationsFragment : Fragment() {

    private val viewModel: LocationsViewModel by viewModel()

    private lateinit var locationListener: LocationScreenOne

    private val locationsAdapter = LocationsAdapter(LocationsListener {
        it.id?.let { locationId -> locationListener.openLocationScreenOne(locationId) }
    })

    override fun onAttach(context: Context) {
        super.onAttach(context)
        locationListener =
            FragmentListenerUtils.getFragmentListener(this, LocationScreenOne::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentLocationsBinding>(
        inflater,
        R.layout.fragment_locations,
        container,
        false
    ).apply {
        viewModel = this@LocationsFragment.viewModel
        lifecycleOwner = viewLifecycleOwner

    }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        viewModel.getLocations()

        with(recyclerView) {
            val manager = GridLayoutManager(activity, 1)
            layoutManager = manager
            adapter = locationsAdapter
        }

        buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }

    }

    private fun observeViewModel() {
        viewModel.location.observe(viewLifecycleOwner, {
            if (it != null) {
                it.results?.let { results -> locationsAdapter.addHeaderAndSubmitList(results) }
                pbPost.isGone = true
                backButton.isGone = viewModel.visiblePrev()
                nextButton.isGone = viewModel.visibleNext()
            }
        })
    }

}