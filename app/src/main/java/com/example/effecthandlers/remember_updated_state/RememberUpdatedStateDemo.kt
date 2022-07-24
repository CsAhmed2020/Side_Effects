package com.example.effecthandlers.remember_updated_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

// reference a value in an effect that
// shouldn't restart if the value changes.
// in some situations you might want to capture a value in your effect that,
// if it changes, you do not want the effect to restart.
// In order to do this, it is required to use rememberUpdatedState
@Composable
fun RememberUpdatedStateDemo(
    onTimeOut:() -> Unit
) {
    // This will always refer to the latest onTimeout function that
    // RememberUpdatedStateDemo was recomposed with
    val updateOnTimeout by rememberUpdatedState(newValue = onTimeOut)

    // Create an effect that matches the lifecycle of RememberUpdatedStateDemo.
    // If RememberUpdatedStateDemo recomposes, the delay shouldn't start again.
    //if a state variable is updated,
    //the side effect will not get the latest state variable change.
    LaunchedEffect(key1 = true){
        delay(3000L)
        //onTimeOut() if i use it , it will launch only with first fun exec and ignore any re-execute of this onTimeOut fun.
        updateOnTimeout()
    }
}