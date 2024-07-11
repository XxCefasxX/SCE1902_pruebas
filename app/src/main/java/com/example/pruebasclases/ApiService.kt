package com.example.pruebasclases

import retrofit2.http.GET
import retrofit2.http.Path

const val CHARACTER_ID = "character_id"
const val CHARACTER = "character/{$CHARACTER_ID}/"

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): CharacterResponse

    @GET(CHARACTER)
    suspend fun getCharacterDetails(
        @Path(CHARACTER_ID) character_id: String
    ): DetailsResponse
}