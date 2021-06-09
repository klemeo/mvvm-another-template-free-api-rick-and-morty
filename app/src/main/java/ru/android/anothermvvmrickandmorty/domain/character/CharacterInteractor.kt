package ru.android.anothermvvmrickandmorty.domain.character

import androidx.lifecycle.LiveData
import ru.android.anothermvvmrickandmorty.domain.models.character_body.CharacterResult

interface CharacterInteractor {

    fun getCharacter(id: Int): LiveData<Result<CharacterResult>>

}