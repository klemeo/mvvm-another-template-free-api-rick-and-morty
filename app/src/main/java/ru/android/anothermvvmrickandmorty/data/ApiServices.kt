package ru.android.anothermvvmrickandmorty.data

import retrofit2.Call
import retrofit2.http.*
import ru.android.anothermvvmrickandmorty.data.models.character_responses.CharacterDto
import ru.android.anothermvvmrickandmorty.data.models.character_responses.CharacterResultDto
import ru.android.anothermvvmrickandmorty.data.models.episode_responses.EpisodeDto
import ru.android.anothermvvmrickandmorty.data.models.episode_responses.EpisodeResultDto
import ru.android.anothermvvmrickandmorty.data.models.location_responses.LocationDto
import ru.android.anothermvvmrickandmorty.data.models.location_responses.LocationResultDto

interface ApiServices {

    @GET("character")
    fun getCharacters(
        @Query("page") page: Int?
    ): Call<CharacterDto>

    @GET("character/{id}")
    fun getCharacter(
        @Path("id") id: Int
    ): Call<CharacterResultDto>

    @GET("location")
    fun getLocations(
        @Query("page") page: Int?
    ): Call<LocationDto>

    @GET("location/{id}")
    fun getLocation(
        @Path("id") id: Int
    ): Call<LocationResultDto>

    @GET("episode")
    fun getEpisodes(
        @Query("page") page: Int?
    ): Call<EpisodeDto>

    @GET("episode/{id}")
    fun getEpisode(
        @Path("id") id: Int
    ): Call<EpisodeResultDto>

}