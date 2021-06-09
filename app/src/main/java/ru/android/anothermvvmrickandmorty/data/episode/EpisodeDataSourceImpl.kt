package ru.android.anothermvvmrickandmorty.data.episode

import ru.android.anothermvvmrickandmorty.base.RetrofitDataSource
import ru.android.anothermvvmrickandmorty.data.InquiryApiClient
import ru.android.anothermvvmrickandmorty.data.converters.toDomain
import ru.android.anothermvvmrickandmorty.domain.episode.EpisodeDataSource
import ru.android.anothermvvmrickandmorty.domain.models.episode_body.EpisodeResult

class EpisodeDataSourceImpl : EpisodeDataSource, RetrofitDataSource {

    override fun getEpisode(id: Int): EpisodeResult {
        val result = executeWithResponse {
            InquiryApiClient.getApiClient().getEpisode(id)
        }
        return result.toDomain()
    }

}