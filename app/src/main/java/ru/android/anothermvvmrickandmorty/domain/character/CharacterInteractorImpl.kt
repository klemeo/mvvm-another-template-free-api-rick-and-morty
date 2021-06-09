package ru.android.anothermvvmrickandmorty.domain.character

import androidx.lifecycle.LiveData
import ru.android.anothermvvmrickandmorty.base.CoroutineInteractor
import ru.android.anothermvvmrickandmorty.base.scopedLiveData
import ru.android.anothermvvmrickandmorty.domain.models.character_body.CharacterResult

class CharacterInteractorImpl(
    private val characterDataSource: CharacterDataSource
) : CoroutineInteractor(), CharacterInteractor {

    override fun getCharacter(id: Int): LiveData<Result<CharacterResult>> =
        scopedLiveData {
            try {
                val result = characterDataSource.getCharacter(id)
                emit(Result.success(result))
            } catch (e: Exception) {

            }
        }

}