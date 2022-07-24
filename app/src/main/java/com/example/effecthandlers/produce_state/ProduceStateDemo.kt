package com.example.effecthandlers.produce_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow


@Composable
fun produceStateDemo(counter:Int) : State<Int> {
    //it is like Disposable state  + it produce state value with remember
    // it await dispose to terminate
    // it similar to flow
    return produceState(initialValue = 0){
        while(value < counter)
        delay(1000L)
        value++
    }

    /**
    // it similar to flow
    return flow<Int> {
        var value = 0
        emit(value)
        while (value < counter) {
            delay(1000L)
            value++
            emit(value)
        }
    }.collectAsState(initial = 0)

    */
}