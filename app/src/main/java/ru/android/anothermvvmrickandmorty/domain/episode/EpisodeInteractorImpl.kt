package ru.android.anothermvvmrickandmorty.domain.episode

import androidx.lifecycle.LiveData
import ru.android.anothermvvmrickandmorty.base.CoroutineInteractor
import ru.android.anothermvvmrickandmorty.base.scopedLiveData
import ru.android.anothermvvmrickandmorty.domain.models.episode_body.EpisodeResult

class EpisodeInteractorImpl(
    private val episodeDataSource: EpisodeDataSource
) : CoroutineInteractor(), EpisodeInteractor {

    override fun getEpisode(id: Int): LiveData<Result<EpisodeResult>> =
        scopedLiveData {
            try {
                val result = episodeDataSource.getEpisode(id)
                emit(Result.success(result))
            } catch (e: Exception) {

            }
        }

}