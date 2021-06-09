package ru.android.anothermvvmrickandmorty.domain.locations

import ru.android.anothermvvmrickandmorty.domain.models.location_body.Location

interface LocationsDataSource {

    fun getLocations(page: Int?): Location

}