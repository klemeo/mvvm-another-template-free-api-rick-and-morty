package ru.android.anothermvvmrickandmorty.presentation.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.android.anothermvvmrickandmorty.base.ResultObserverDelegate
import ru.android.anothermvvmrickandmorty.domain.characters.CharactersInteractor
import ru.android.anothermvvmrickandmorty.domain.models.character_body.Character
import ru.android.anothermvvmrickandmorty.presentation.utils.pageCharacters

class CharactersViewModel(
    private val charactersInteractor: CharactersInteractor
) : ViewModel() {

    var character = MutableLiveData<Character?>()

    private var getCharactersObserver = Observer<Result<Character>> { result ->
        handleCategoryResult(result)
    }

    private var getCharactersLiveData: LiveData<Result<Character>>?
            by ResultObserverDelegate(getCharactersObserver)

    fun getCharacters(page: Int? = null) {
        getCharactersLiveData = charactersInteractor.getCharacters(page)
    }

    private fun handleCategoryResult(result: Result<Character>) {
        result
            .onSuccess {
                character.postValue(it)
            }
            .onFailure {

            }
    }

    fun flippingNext() {
        val nextPage = character.value?.info?.next?.pageCharacters()
        if (nextPage != null) getCharacters(nextPage)
    }

    fun flippingPrev() {
        val prevPage = character.value?.info?.prev?.toString()?.pageCharacters()
        if (prevPage != null) getCharacters(prevPage)
    }

    fun visiblePrev(): Boolean {
        val prevPage = character.value?.info?.prev?.toString()?.pageCharacters()
        return prevPage == null
    }

    fun visibleNext(): Boolean {
        val nextPage = character.value?.info?.next?.pageCharacters()
        return nextPage == null
    }

}