package com.example.pruebasclases

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("data") val Characters: List<Character>
)


data class Character(
    val name: String,
    val _id: Int,
    @SerializedName("imageUrl")val img: String)


data class DetailsResponse(
    @SerializedName("data") val Details: Character
)

data class SearchResponse(
    @SerializedName("data") val Characters: List<Character>
)

