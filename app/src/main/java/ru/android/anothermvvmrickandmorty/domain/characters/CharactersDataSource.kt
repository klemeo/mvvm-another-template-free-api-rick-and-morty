package ru.android.anothermvvmrickandmorty.domain.characters

import ru.android.anothermvvmrickandmorty.domain.models.character_body.Character

interface CharactersDataSource {

    fun getCharacters(page: Int?) : Character

}