package ru.android.anothermvvmrickandmorty.domain.episode

import androidx.lifecycle.LiveData
import ru.android.anothermvvmrickandmorty.domain.models.episode_body.EpisodeResult

interface EpisodeInteractor {

    fun getEpisode(id: Int): LiveData<Result<EpisodeResult>>

}