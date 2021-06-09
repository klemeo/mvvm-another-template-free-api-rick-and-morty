package ru.android.anothermvvmrickandmorty.domain.locations

import androidx.lifecycle.LiveData
import ru.android.anothermvvmrickandmorty.domain.models.location_body.Location

interface LocationsInteractor {

    fun getLocations(page: Int?): LiveData<Result<Location>>

}