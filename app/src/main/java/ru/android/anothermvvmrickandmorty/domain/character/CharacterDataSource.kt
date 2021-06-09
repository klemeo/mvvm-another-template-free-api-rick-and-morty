package ru.android.anothermvvmrickandmorty.domain.character

import ru.android.anothermvvmrickandmorty.domain.models.character_body.CharacterResult

interface CharacterDataSource {

    fun getCharacter(id: Int): CharacterResult

}