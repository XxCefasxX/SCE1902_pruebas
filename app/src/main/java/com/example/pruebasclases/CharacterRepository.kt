package com.example.pruebasclases

class CharacterRepository(private val apiService: ApiService) {

    suspend fun getCharacters(): List<Character> {
        return apiService.getCharacters().Characters
    }
}