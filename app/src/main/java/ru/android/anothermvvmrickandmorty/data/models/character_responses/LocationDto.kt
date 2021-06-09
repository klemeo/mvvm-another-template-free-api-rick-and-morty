package ru.android.anothermvvmrickandmorty.data.models.character_responses


import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)