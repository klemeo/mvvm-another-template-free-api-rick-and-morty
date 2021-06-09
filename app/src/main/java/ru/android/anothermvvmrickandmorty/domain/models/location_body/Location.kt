package ru.android.anothermvvmrickandmorty.domain.models.location_body

data class Location(
    val info: Info?,
    val results: List<LocationResult>?
)