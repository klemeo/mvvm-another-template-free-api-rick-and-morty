package ru.android.anothermvvmrickandmorty.data.models.episode_responses


import com.google.gson.annotations.SerializedName

data class EpisodeDto(
    @SerializedName("info")
    val info: InfoDto?,
    @SerializedName("results")
    val results: List<EpisodeResultsDto>?
)