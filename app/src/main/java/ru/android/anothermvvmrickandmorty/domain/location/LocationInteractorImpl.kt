package ru.android.anothermvvmrickandmorty.domain.location

import androidx.lifecycle.LiveData
import ru.android.anothermvvmrickandmorty.base.CoroutineInteractor
import ru.android.anothermvvmrickandmorty.base.scopedLiveData
import ru.android.anothermvvmrickandmorty.domain.models.location_body.LocationResult

class LocationInteractorImpl(
    private val locationDataSource: LocationDataSource
) : CoroutineInteractor(), LocationInteractor {

    override fun getLocation(id: Int): LiveData<Result<LocationResult>> =
        scopedLiveData {
            try {
                val result = locationDataSource.getLocation(id)
                emit(Result.success(result))
            } catch (e: Exception) {

            }
        }

}