package ru.android.anothermvvmrickandmorty.data.characters

import ru.android.anothermvvmrickandmorty.base.RetrofitDataSource
import ru.android.anothermvvmrickandmorty.data.InquiryApiClient
import ru.android.anothermvvmrickandmorty.data.converters.toDomain
import ru.android.anothermvvmrickandmorty.domain.characters.CharactersDataSource
import ru.android.anothermvvmrickandmorty.domain.models.character_body.Character

class CharactersDataSourceImpl : CharactersDataSource, RetrofitDataSource {

    override fun getCharacters(page: Int?): Character {
        val result = executeWithResponse {
            InquiryApiClient.getApiClient().getCharacters(page)
        }
        return result.toDomain()
    }

}