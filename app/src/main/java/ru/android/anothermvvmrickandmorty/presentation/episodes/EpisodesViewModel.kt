package ru.android.anothermvvmrickandmorty.presentation.episodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.android.anothermvvmrickandmorty.base.ResultObserverDelegate
import ru.android.anothermvvmrickandmorty.domain.episodes.EpisodesInteractor
import ru.android.anothermvvmrickandmorty.domain.models.episode_body.Episode
import ru.android.anothermvvmrickandmorty.presentation.utils.pageCharacters
import ru.android.anothermvvmrickandmorty.presentation.utils.pageEpisodes

class EpisodesViewModel(
    private val episodesInteractor: EpisodesInteractor
) : ViewModel() {

    var episode = MutableLiveData<Episode?>()

    private var getEpisodesObserver = Observer<Result<Episode>> { result ->
        handleCategoryResult(result)
    }

    private var getEpisodesLiveData: LiveData<Result<Episode>>?
            by ResultObserverDelegate(getEpisodesObserver)

    fun getEpisodes(page: Int? = null) {
        getEpisodesLiveData = episodesInteractor.getEpisodes(page)
    }

    private fun handleCategoryResult(result: Result<Episode>) {
        result
            .onSuccess {
                episode.postValue(it)
            }
            .onFailure {

            }
    }

    fun flippingNext() {
        val nextPage = episode.value?.info?.next?.pageEpisodes()
        if (nextPage != null) getEpisodes(nextPage)
    }

    fun flippingPrev() {
        val prevPage = episode.value?.info?.prev?.toString()?.pageEpisodes()
        if (prevPage != null) getEpisodes(prevPage)
    }

    fun visiblePrev(): Boolean {
        val prevPage = episode.value?.info?.prev?.toString()?.pageEpisodes()
        return prevPage == null
    }

    fun visibleNext(): Boolean {
        val nextPage = episode.value?.info?.next?.pageEpisodes()
        return nextPage == null
    }

}