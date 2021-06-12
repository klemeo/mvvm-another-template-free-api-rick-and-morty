package ru.android.anothermvvmrickandmorty.presentation.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.android.anothermvvmrickandmorty.base.ResultObserverDelegate
import ru.android.anothermvvmrickandmorty.domain.location.LocationInteractor
import ru.android.anothermvvmrickandmorty.domain.models.location_body.LocationResult

class LocationViewModel(
    private val locationInteractor: LocationInteractor
) : ViewModel() {

    var location = MutableLiveData<LocationResult?>()

    private var getLocationObserver = Observer<Result<LocationResult>> { result ->
        handleLocationResult(result)
    }

    private var getLocationLiveData: LiveData<Result<LocationResult>>?
            by ResultObserverDelegate(getLocationObserver)

    fun getLocation(id: Int) {
        getLocationLiveData = locationInteractor.getLocation(id)
    }

    private fun handleLocationResult(result: Result<LocationResult>) {
        result
            .onSuccess {
                location.postValue(it)
            }
            .onFailure {

            }
    }

}