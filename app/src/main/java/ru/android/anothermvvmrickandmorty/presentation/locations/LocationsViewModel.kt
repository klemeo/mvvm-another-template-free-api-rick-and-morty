package ru.android.anothermvvmrickandmorty.presentation.locations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.android.anothermvvmrickandmorty.base.ResultObserverDelegate
import ru.android.anothermvvmrickandmorty.domain.locations.LocationsInteractor
import ru.android.anothermvvmrickandmorty.domain.models.location_body.Location
import ru.android.anothermvvmrickandmorty.presentation.utils.pageLocations

class LocationsViewModel(
    private val locationsInteractor: LocationsInteractor
) : ViewModel() {

    var location = MutableLiveData<Location?>()

    private var getLocationsObserver = Observer<Result<Location>> { result ->
        handleLocationResult(result)
    }

    private var getLocationsLiveData: LiveData<Result<Location>>?
            by ResultObserverDelegate(getLocationsObserver)

    fun getLocations(page: Int? = null) {
        getLocationsLiveData = locationsInteractor.getLocations(page)
    }

    private fun handleLocationResult(result: Result<Location>) {
        result
            .onSuccess {
                location.postValue(it)
            }
            .onFailure {

            }
    }


    fun flippingNext() {
        val nextPage = location.value?.info?.next?.pageLocations()
        if (nextPage != null) getLocations(nextPage)
    }

    fun flippingPrev() {
        val prevPage = location.value?.info?.prev?.toString()?.pageLocations()
        if (prevPage != null) getLocations(prevPage)
    }

    fun visiblePrev(): Boolean {
        val prevPage = location.value?.info?.prev?.toString()?.pageLocations()
        return prevPage == null
    }

    fun visibleNext(): Boolean {
        val nextPage = location.value?.info?.next?.pageLocations()
        return nextPage == null
    }

}