package ru.android.anothermvvmrickandmorty.domain.characters

import androidx.lifecycle.LiveData
import ru.android.anothermvvmrickandmorty.base.CoroutineInteractor
import ru.android.anothermvvmrickandmorty.base.scopedLiveData
import ru.android.anothermvvmrickandmorty.domain.models.character_body.Character

class CharactersInteractorImpl(
    private val charactersDataSource: CharactersDataSource
) : CoroutineInteractor(), CharactersInteractor {

    override fun getCharacters(page: Int?): LiveData<Result<Character>> =
        scopedLiveData {
            try {
                val result = charactersDataSource.getCharacters(page)
                emit(Result.success(result))
            } catch (e: Exception) {

            }
        }

}