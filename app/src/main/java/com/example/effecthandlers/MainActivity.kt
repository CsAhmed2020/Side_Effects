package com.example.effecthandlers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*

import com.example.effecthandlers.ui.theme.LaunchedEffectTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember {
                mutableStateOf("")
            }
            LaunchedEffectTheme {
                /**
                //side effect ex
                Button(
                onClick = {
                text += "*"
                }) {
                    i++ // here the side effect happened....
                    // as this value will be not controlled as it will be changed with every recomposition
                    Text(text = text)
                }
                */

                //launched effect : trigger on first composition or key changed
                //launched effect composable fun only used in another composable fun
                // when key value changed the launched effect will be cancelled and relaunched
                LaunchedEffect(key1 = text){
                    delay(1000L)
                    println("text value : $text")
                }
            }
        }
    }
}

