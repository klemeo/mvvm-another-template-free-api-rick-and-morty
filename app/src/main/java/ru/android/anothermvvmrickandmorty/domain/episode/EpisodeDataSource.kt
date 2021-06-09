package ru.android.anothermvvmrickandmorty.domain.episode

import ru.android.anothermvvmrickandmorty.domain.models.episode_body.EpisodeResult

interface EpisodeDataSource {

    fun getEpisode(id: Int): EpisodeResult

}