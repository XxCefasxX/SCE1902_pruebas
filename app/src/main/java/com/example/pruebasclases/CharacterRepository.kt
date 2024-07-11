package com.example.pruebasclases

class CharacterRepository(private val apiService: ApiService) {

    suspend fun getCharacters(): List<Character> {
        return apiService.getCharacters().Characters
    }

    suspend fun getCharacterDetails(character_id:String): Character {
        return apiService.getCharacterDetails(character_id).Details
    }

}