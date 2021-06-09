package ru.android.anothermvvmrickandmorty.data.models.location_responses


import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("info")
    val info: InfoDto?,
    @SerializedName("results")
    val results: List<LocationResultsDto>?
)