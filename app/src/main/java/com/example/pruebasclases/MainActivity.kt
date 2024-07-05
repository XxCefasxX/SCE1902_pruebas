package com.example.pruebasclases

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebasclases.ui.theme.PruebasClasesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebasClasesTheme {
                Characterscreen()

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MyApp() {
    // Estado mutable para la lista de elementos
    var items = remember { mutableStateListOf("Elemento 1", "Elemento 2") }

    // Función para agregar un nuevo elemento
    fun addItem(item: String) {
        Log.i("MyApp","sasas")
           items.add(item)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Lista de elementos
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(items) { item ->
                Text(text = item)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        // Botón para agregar un nuevo elemento
        Button(
            onClick = { addItem("Nuevo Elemento") },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Agregar Elemento")
        }
    }
}