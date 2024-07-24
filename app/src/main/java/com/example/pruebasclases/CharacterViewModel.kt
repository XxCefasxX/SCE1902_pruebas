package com.example.pruebasclases

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterViewModel(application: Application) : AndroidViewModel(application) {


    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val httpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()


    private val apiService = Retrofit.Builder()
        .baseUrl("https://api.disneyapi.dev/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
        .create(ApiService::class.java)

    private val repository = CharacterRepository(apiService)


    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters


    private val _character = MutableLiveData<Character>()
    val character: LiveData<Character> = _character


    init {
        fetchCharacters()
    }

     fun fetchCharacters() = viewModelScope.launch {
        val charList = repository.getCharacters()
        _characters.value = charList
    }

    fun getCharacter(character_id:String) = viewModelScope.launch {
        val _details = repository.getCharacterDetails(character_id)
        _character.value = _details
    }

    fun SearchCharacter(character_name:String) = viewModelScope.launch {
        val charList = repository.SearchChracterName(character_name)
        _characters.value = charList
    }

}