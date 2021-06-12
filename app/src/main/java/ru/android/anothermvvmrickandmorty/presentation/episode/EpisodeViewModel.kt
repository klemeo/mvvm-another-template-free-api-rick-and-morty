package ru.android.anothermvvmrickandmorty.presentation.episode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.android.anothermvvmrickandmorty.base.ResultObserverDelegate
import ru.android.anothermvvmrickandmorty.domain.episode.EpisodeInteractor
import ru.android.anothermvvmrickandmorty.domain.models.episode_body.EpisodeResult

class EpisodeViewModel(
    private val episodeInteractor: EpisodeInteractor
) : ViewModel() {


    var episode = MutableLiveData<EpisodeResult?>()

    private var getEpisodeObserver = Observer<Result<EpisodeResult>> { result ->
        handleCategoryResult(result)
    }

    private var getEpisodeLiveData: LiveData<Result<EpisodeResult>>?
            by ResultObserverDelegate(getEpisodeObserver)

    fun getEpisode(id: Int) {
        getEpisodeLiveData = episodeInteractor.getEpisode(id)
    }

    private fun handleCategoryResult(result: Result<EpisodeResult>) {
        result
            .onSuccess {
                episode.postValue(it)
            }
            .onFailure {

            }
    }

}