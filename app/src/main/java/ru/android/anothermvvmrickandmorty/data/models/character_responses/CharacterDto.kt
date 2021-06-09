package ru.android.anothermvvmrickandmorty.data.models.character_responses


import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("info")
    val info: InfoDto?,
    @SerializedName("results")
    val results: List<CharacterResultsDto>?
)