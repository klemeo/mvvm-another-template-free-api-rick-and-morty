package ru.android.anothermvvmrickandmorty.domain.models.episode_body

data class EpisodeResult(
    val airDate: String?,
    val characters: List<String>?,
    val created: String?,
    val episode: String?,
    val id: Int?,
    val name: String?,
    val url: String?
)