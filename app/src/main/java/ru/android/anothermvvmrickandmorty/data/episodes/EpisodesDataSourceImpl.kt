package ru.android.anothermvvmrickandmorty.data.episodes

import ru.android.anothermvvmrickandmorty.base.RetrofitDataSource
import ru.android.anothermvvmrickandmorty.data.InquiryApiClient
import ru.android.anothermvvmrickandmorty.data.converters.toDomain
import ru.android.anothermvvmrickandmorty.domain.episodes.EpisodesDataSource
import ru.android.anothermvvmrickandmorty.domain.models.episode_body.Episode

class EpisodesDataSourceImpl : EpisodesDataSource, RetrofitDataSource {

    override fun getEpisodes(page: Int?): Episode {
        val result = executeWithResponse {
            InquiryApiClient.getApiClient().getEpisodes(page)
        }
        return result.toDomain()
    }

}