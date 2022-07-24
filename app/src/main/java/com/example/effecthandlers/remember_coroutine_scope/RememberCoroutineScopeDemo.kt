package com.example.effecthandlers.remember_coroutine_scope

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RememberCoroutineScopeDemo() {
    //RCS : trigger on first composition
    //next line is advantage of it : manual launch through scope
    //scope val aware of composition here
    //when recomposition all coroutines in next scope will cancelled
    //RCS only used in callbacks (like onClick)
    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {
            delay(1000L)
            print("Hello world!")
        }
    }) {}
}