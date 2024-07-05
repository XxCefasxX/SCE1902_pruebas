package com.example.pruebasclases

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun Characterscreen(userViewModel: CharacterViewModel = viewModel()) {
    val characters by userViewModel.characters.collectAsState()
    Log.i("Characterscreen", characters.toString())
    Column {
        LazyColumn {
            items(characters) { character ->
                CharacterItem(character = character)
            }
        }
    }


}

@Composable
fun CharacterItem(character: Character) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = character.name)
    }
}