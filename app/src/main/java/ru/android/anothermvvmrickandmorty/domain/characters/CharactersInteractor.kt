package ru.android.anothermvvmrickandmorty.domain.characters

import androidx.lifecycle.LiveData
import ru.android.anothermvvmrickandmorty.domain.models.character_body.Character

interface CharactersInteractor {

    fun getCharacters(page: Int?): LiveData<Result<Character>>

}