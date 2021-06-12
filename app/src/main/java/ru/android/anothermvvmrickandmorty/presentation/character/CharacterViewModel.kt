package ru.android.anothermvvmrickandmorty.presentation.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.android.anothermvvmrickandmorty.base.ResultObserverDelegate
import ru.android.anothermvvmrickandmorty.domain.character.CharacterInteractor
import ru.android.anothermvvmrickandmorty.domain.models.character_body.CharacterResult

class CharacterViewModel(
    private val characterInteractor: CharacterInteractor
) : ViewModel() {

    var character = MutableLiveData<CharacterResult?>()

    private var getCharacterObserver = Observer<Result<CharacterResult>> { result ->
        handleCharacterResult(result)
    }

    private var getCharacterLiveData: LiveData<Result<CharacterResult>>?
            by ResultObserverDelegate(getCharacterObserver)

    fun getCharacter(id: Int) {
        getCharacterLiveData = characterInteractor.getCharacter(id)
    }

    private fun handleCharacterResult(result: Result<CharacterResult>) {
        result
            .onSuccess {
                character.postValue(it)
            }
            .onFailure {

            }

    }

}