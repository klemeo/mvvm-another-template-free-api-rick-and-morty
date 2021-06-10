package ru.android.anothermvvmrickandmorty.presentation.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.android.anothermvvmrickandmorty.base.ResultObserverDelegate
import ru.android.anothermvvmrickandmorty.domain.characters.CharactersInteractor
import ru.android.anothermvvmrickandmorty.domain.models.character_body.Character

class CharactersViewModel(
    private val charactersInteractor: CharactersInteractor
) : ViewModel() {

    var character = MutableLiveData<Character?>()

    private var getCategoryObserver = Observer<Result<Character>> { result ->
        handleCategoryResult(result)
    }

    private var getCategoryLiveData: LiveData<Result<Character>>?
            by ResultObserverDelegate(getCategoryObserver)

    fun getCharacters(page: Int? = null) {
        getCategoryLiveData = charactersInteractor.getCharacters(page)
    }

    private fun handleCategoryResult(result: Result<Character>) {
        result
            .onSuccess {
                character.postValue(it)
            }
            .onFailure {

            }
    }

}