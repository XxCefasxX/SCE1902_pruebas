package com.example.pruebasclases

import android.graphics.Color.YELLOW
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.Card
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import coil.compose.AsyncImage


@Composable
fun Characterscreen(charactersViewModel: CharacterViewModel = viewModel(), nav: NavHostController) {
    val characters by charactersViewModel.characters.collectAsState()
    var name by remember {
        mutableStateOf("")
    }
    Log.i("Characterscreen", characters.toString())
    Column(modifier = Modifier.background(Color.Green)) {
        Row {
            TextField(value = name, onValueChange = { searchName ->
                name = searchName
                charactersViewModel.SearchCharacter(name)
            })
            Button(onClick = {
                charactersViewModel.SearchCharacter(name)
            }) {

            }
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 100.dp), // Tamaño mínimo de cada celda
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(characters) { character ->
                CharacterItem(character = character, nav)
            }
        }
    }


}

@Composable
fun CharacterItem(character: Character, nav: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f) // Hacer que la altura sea igual al ancho
            .padding(8.dp)
            .clickable {
                nav.navigate("p4/${character._id}")
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = character.img,
                contentDescription = null,
            )
            Text(character.name, color = androidx.compose.ui.graphics.Color.Red)
        }

    }

}

@Composable
fun CharacterScreen(
    charactersViewModel: CharacterViewModel = viewModel(),
    character_id: String,
    nav: NavHostController
) {
    charactersViewModel.getCharacter(character_id)
    val character by charactersViewModel.character.observeAsState()
    character?.let {
        Column(
            modifier =
            Modifier
                .fillMaxSize()
                .background(Color.Red)
        ) {
            AsyncImage(
                model = it.img,
                contentDescription = "",
                modifier = Modifier.clickable { nav.navigate("home") })
            Text(text = it.name)
        }
    }

}