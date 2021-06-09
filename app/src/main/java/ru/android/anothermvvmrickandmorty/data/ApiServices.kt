package ru.android.anothermvvmrickandmorty.data

import retrofit2.http.*
import ru.android.anothermvvmrickandmorty.data.models.character_responses.CharacterDto
import ru.android.anothermvvmrickandmorty.data.models.character_responses.CharacterResultsDto
import ru.android.anothermvvmrickandmorty.data.models.episode_responses.EpisodeDto
import ru.android.anothermvvmrickandmorty.data.models.episode_responses.EpisodeResultsDto
import ru.android.anothermvvmrickandmorty.data.models.location_responses.LocationDto
import ru.android.anothermvvmrickandmorty.data.models.location_responses.LocationResultsDto

interface ApiServices {

    @GET("character")
    fun getCharacters(
        @Query("page") page: Int?
    ): CharacterDto

    @GET("character/{id}")
    fun getCharacter(
        @Path("id") id: Int
    ): CharacterResultsDto

    @GET("location")
    fun getLocations(
        @Query("page") page: Int?
    ): LocationDto

    @GET("location/{id}")
    fun getLocation(
        @Path("id") id: Int
    ): LocationResultsDto

    @GET("episode")
    fun getEpisodes(
        @Query("page") page: Int?
    ): EpisodeDto

    @GET("episode/{id}")
    fun getEpisode(
        @Path("id") id: Int
    ): EpisodeResultsDto

}