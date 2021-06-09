package ru.android.anothermvvmrickandmorty.data.converters

import ru.android.anothermvvmrickandmorty.data.models.character_responses.*
import ru.android.anothermvvmrickandmorty.domain.models.character_body.*

fun CharacterDto.toDomain(): Character = Character(
    info = info?.toDomain(),
    results = results?.map { it.toDomain() }
)

fun InfoDto.toDomain(): Info = Info(
    count = count,
    next = next,
    pages = pages,
    prev = prev
)

fun CharacterResultDto.toDomain(): CharacterResult = CharacterResult(
    created = created,
    episode = episode,
    gender = gender,
    id = id,
    image = image,
    location = location?.toDomain(),
    name = name,
    origin = origin?.toDomain(),
    species = species,
    status = status,
    type = type,
    url = url
)

fun LocationDto.toDomain(): Location = Location(
    name = name,
    url = url
)

fun OriginDto.toDomain(): Origin = Origin(
    name = name,
    url = url
)