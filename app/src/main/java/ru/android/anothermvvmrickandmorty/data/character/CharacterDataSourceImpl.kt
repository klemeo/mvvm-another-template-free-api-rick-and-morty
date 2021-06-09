package ru.android.anothermvvmrickandmorty.data.character

import ru.android.anothermvvmrickandmorty.base.RetrofitDataSource
import ru.android.anothermvvmrickandmorty.data.InquiryApiClient
import ru.android.anothermvvmrickandmorty.data.converters.toDomain
import ru.android.anothermvvmrickandmorty.domain.character.CharacterDataSource
import ru.android.anothermvvmrickandmorty.domain.models.character_body.CharacterResult

class CharacterDataSourceImpl : CharacterDataSource, RetrofitDataSource {

    override fun getCharacter(id: Int): CharacterResult {
        val result = executeWithResponse {
            InquiryApiClient.getApiClient().getCharacter(id)
        }
        return result.toDomain()
    }

}