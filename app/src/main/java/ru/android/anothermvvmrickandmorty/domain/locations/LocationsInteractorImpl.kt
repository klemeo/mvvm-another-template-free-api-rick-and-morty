package ru.android.anothermvvmrickandmorty.domain.locations

import androidx.lifecycle.LiveData
import ru.android.anothermvvmrickandmorty.base.CoroutineInteractor
import ru.android.anothermvvmrickandmorty.base.scopedLiveData
import ru.android.anothermvvmrickandmorty.domain.models.location_body.Location

class LocationsInteractorImpl(
    private val locationsDataSource: LocationsDataSource
) : CoroutineInteractor(), LocationsInteractor {

    override fun getLocations(page: Int?): LiveData<Result<Location>> =
        scopedLiveData {
            try {
                val result = locationsDataSource.getLocations(page)
                emit(Result.success(result))
            } catch (e: Exception) {

            }
        }

}