package ru.android.anothermvvmrickandmorty.data.location

import ru.android.anothermvvmrickandmorty.base.RetrofitDataSource
import ru.android.anothermvvmrickandmorty.data.InquiryApiClient
import ru.android.anothermvvmrickandmorty.data.converters.toDomain
import ru.android.anothermvvmrickandmorty.domain.location.LocationDataSource
import ru.android.anothermvvmrickandmorty.domain.models.location_body.LocationResult

class LocationDataSourceImpl : LocationDataSource, RetrofitDataSource {

    override fun getLocation(id: Int): LocationResult {
        val result = executeWithResponse {
            InquiryApiClient.getApiClient().getLocation(id)
        }
        return result.toDomain()
    }

}