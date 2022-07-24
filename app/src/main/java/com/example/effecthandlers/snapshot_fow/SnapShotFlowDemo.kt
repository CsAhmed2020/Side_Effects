package com.example.effecthandlers.snapshot_fow

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull

//trigger on value changed and produce kotlin flow
//We can use this within a side effect e.g. LaunchedEffect
@Composable
fun SnapShotFlowDemo() {

    /**
     * LaunchedEffect(someState) {
    snapshotFlow { someState.someStateValue }
    .someFlowOperation { /* */ }
    .collect { /* need to trigger within coroutine */ }
    }
     */

    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = scaffoldState){
        snapshotFlow {scaffoldState.snackbarHostState}
            .mapNotNull { it.currentSnackbarData?.message }
            .distinctUntilChanged()
            .collect { message ->
                println("A snackbar message : $message")
            }
    }
}