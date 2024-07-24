package com.example.pruebasclases

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val CHARACTER_ID = "character_id"
const val CHARACTER = "character/{$CHARACTER_ID}/"

const val CHARACTER_NAME = "name"


interface ApiService {

    @GET("character")
    suspend fun getCharacters(): CharacterResponse

    @GET(CHARACTER)
    suspend fun getCharacterDetails(
        @Path(CHARACTER_ID) character_id: String
    ): DetailsResponse

    @GET(CHARACTER)
    suspend fun SearchCHaracter(
        @Query(CHARACTER_NAME) character_name: String
    ): SearchResponse
}