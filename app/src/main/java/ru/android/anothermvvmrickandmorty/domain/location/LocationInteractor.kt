package ru.android.anothermvvmrickandmorty.domain.location

import androidx.lifecycle.LiveData
import ru.android.anothermvvmrickandmorty.domain.models.location_body.LocationResult

interface LocationInteractor {

    fun getLocation(id: Int): LiveData<Result<LocationResult>>

}