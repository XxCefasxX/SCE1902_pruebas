package com.example.pruebasclases

class CharacterRepository(private val apiService: ApiService) {

    suspend fun getCharacters(): List<Character> {
        return apiService.getCharacters().Characters
    }

    suspend fun getCharacterDetails(character_id:String): Character {
        return apiService.getCharacterDetails(character_id).Details
    }

    suspend fun SearchChracterName(character_id:String): List<Character> {
        return apiService.SearchCHaracter(character_id).Characters
    }

}