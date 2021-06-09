package ru.android.anothermvvmrickandmorty.data.locations

import ru.android.anothermvvmrickandmorty.base.RetrofitDataSource
import ru.android.anothermvvmrickandmorty.data.InquiryApiClient
import ru.android.anothermvvmrickandmorty.data.converters.toDomain
import ru.android.anothermvvmrickandmorty.domain.locations.LocationsDataSource
import ru.android.anothermvvmrickandmorty.domain.models.location_body.Location

class LocationsDataSourceImpl : LocationsDataSource, RetrofitDataSource {

    override fun getLocations(page: Int?): Location {
        val result = executeWithResponse {
            InquiryApiClient.getApiClient().getLocations(page)
        }
        return result.toDomain()
    }

}