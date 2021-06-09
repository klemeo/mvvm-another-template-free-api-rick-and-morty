package ru.android.anothermvvmrickandmorty.data.converters

import ru.android.anothermvvmrickandmorty.data.models.episode_responses.EpisodeDto
import ru.android.anothermvvmrickandmorty.data.models.episode_responses.EpisodeResultDto
import ru.android.anothermvvmrickandmorty.data.models.episode_responses.InfoDto
import ru.android.anothermvvmrickandmorty.domain.models.episode_body.Episode
import ru.android.anothermvvmrickandmorty.domain.models.episode_body.EpisodeResult
import ru.android.anothermvvmrickandmorty.domain.models.episode_body.Info

fun EpisodeDto.toDomain(): Episode = Episode(
    info = info?.toDomain(),
    results = results?.map { it.toDomain() }
)

fun InfoDto.toDomain(): Info = Info(
    count = count,
    next = next,
    pages = pages,
    prev = prev
)

fun EpisodeResultDto.toDomain(): EpisodeResult = EpisodeResult(
    airDate = airDate,
    characters = characters,
    created = created,
    episode = episode,
    id = id,
    name = name,
    url = url,
)