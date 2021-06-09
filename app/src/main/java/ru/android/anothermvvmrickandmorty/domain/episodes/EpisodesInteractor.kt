package ru.android.anothermvvmrickandmorty.domain.episodes

import androidx.lifecycle.LiveData
import ru.android.anothermvvmrickandmorty.domain.models.episode_body.Episode

interface EpisodesInteractor {

    fun getEpisodes(page: Int?): LiveData<Result<Episode>>

}