package ru.android.anothermvvmrickandmorty.domain.location

import ru.android.anothermvvmrickandmorty.domain.models.location_body.LocationResult

interface LocationDataSource {

    fun getLocation(id: Int): LocationResult

}