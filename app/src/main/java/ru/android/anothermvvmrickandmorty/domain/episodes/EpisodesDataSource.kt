package ru.android.anothermvvmrickandmorty.domain.episodes

import ru.android.anothermvvmrickandmorty.domain.models.episode_body.Episode

interface EpisodesDataSource {

    fun getEpisodes(page: Int?): Episode

}