package com.example.effecthandlers.derived_state_of

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun DerivedStateOfDemo() {
    var counter by remember {
        mutableStateOf(0)
    }

    /** without using derivedStateOf
     * In remember(value) {...}, whenever the value change,
     * we recompose the entire containing composable function,
     * even when the return value is the same.
     * ex: if returned value false true true ... it will recompose 3 times
    //val counterText = "The counter is $counter"
    */


    //if we use derivedStateOf as shown below,
    // the recomposition will only happen
    // when the counterText changed.
    //ex : if returned value false true true ... it will recompose 2 times
    val counterText by derivedStateOf {
        "The counter is $counter"
    }

    Button(onClick = { counter++ }) {
        Text(text = counterText)
    }
}