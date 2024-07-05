package com.example.pruebasclases

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("data")val Characters: List<Character>
)


data class Character(val name: String, val _id: Int)
