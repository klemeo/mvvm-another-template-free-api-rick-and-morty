package ru.android.anothermvvmrickandmorty.data.converters

import ru.android.anothermvvmrickandmorty.data.models.location_responses.InfoDto
import ru.android.anothermvvmrickandmorty.data.models.location_responses.LocationDto
import ru.android.anothermvvmrickandmorty.data.models.location_responses.LocationResultDto
import ru.android.anothermvvmrickandmorty.domain.models.location_body.Info
import ru.android.anothermvvmrickandmorty.domain.models.location_body.Location
import ru.android.anothermvvmrickandmorty.domain.models.location_body.LocationResult

fun LocationDto.toDomain(): Location = Location(
    info = info?.toDomain(),
    results = results?.map { it.toDomain() }
)

fun InfoDto.toDomain(): Info = Info(
    count = count,
    next = next,
    pages = pages,
    prev = prev
)

fun LocationResultDto.toDomain(): LocationResult = LocationResult(
    created = created,
    dimension = dimension,
    id = id,
    name = name,
    residents = residents,
    type = type,
    url = url,
)