package com.example.pruebasclases

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ColorAnimation() {

    var col2 by rememberSaveable {
        mutableStateOf(false)
    }
    var s by rememberSaveable {
        mutableStateOf(false)
    }
    var hideText by rememberSaveable {
        mutableStateOf(false)
    }
    val realcol2 by animateColorAsState(
        targetValue = if (col2) Color.Red else Color.Green,
        animationSpec = tween(durationMillis = 1000)
    )
    val ss by animateDpAsState(
        targetValue = if (s) 50.dp else 200.dp,
        animationSpec = tween(durationMillis = 1000),
        finishedListener = { hideText = !hideText }
    )
    Box(
        modifier = Modifier
            .size(ss)
            .background(realcol2)
            .clickable {
                col2 = !col2
                s = !s
            }

    ) {
        AnimatedVisibility(!hideText){
            Text(text = "Hola")
        }

    }
}