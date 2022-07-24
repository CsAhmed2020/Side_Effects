package com.example.effecthandlers.side_effect

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun SideEffectDemo() {

    var text by remember { mutableStateOf("") }

    //it will be triggered with every recomposition
    Button(
        onClick = {
            text += "*"
        }) {
        SideEffect {
            println(text)
        }
    }


}