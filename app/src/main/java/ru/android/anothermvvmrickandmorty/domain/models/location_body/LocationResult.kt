package ru.android.anothermvvmrickandmorty.domain.models.location_body

data class LocationResult(
    val created: String?,
    val dimension: String?,
    val id: Int?,
    val name: String?,
    val residents: List<String>?,
    val type: String?,
    val url: String?
)