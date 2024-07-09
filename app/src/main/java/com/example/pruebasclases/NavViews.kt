package com.example.pruebasclases

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun Pantalla1(nav: NavHostController) {
    Column {
        Text(text = "page 1")
        Text(text = "ir a pagina 2", Modifier.clickable {
            nav.navigate("p2")
        })
    }
}

@Composable
fun Pantalla2(nav: NavHostController) {
    Column {
        Text(text = "page 2")
        Text(text = "ir a pagina 3", Modifier.clickable {
            nav.navigate("p3")
        })
    }
}

@Composable
fun Pantalla3(nav: NavHostController) {
    Column {
        Text(text = "page 3")
        Text(text = "ir a pagina 1", Modifier.clickable {
            nav.navigate("p3")
        })
    }
}