package ru.android.anothermvvmrickandmorty.domain.episodes

import androidx.lifecycle.LiveData
import ru.android.anothermvvmrickandmorty.base.CoroutineInteractor
import ru.android.anothermvvmrickandmorty.base.scopedLiveData
import ru.android.anothermvvmrickandmorty.domain.models.episode_body.Episode

class EpisodesInteractorImpl(
    private val episodesDataSource: EpisodesDataSource
) : CoroutineInteractor(), EpisodesInteractor {

    override fun getEpisodes(page: Int?): LiveData<Result<Episode>> =
        scopedLiveData {
            try {
                val result = episodesDataSource.getEpisodes(page)
                emit(Result.success(result))
            } catch (e: Exception) {

            }
        }

}