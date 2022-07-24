package com.example.effecthandlers.launched_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.collect

@Composable
fun LaunchedEffectDemo(
    viewModel: LaunchedEffectViewModel
){
    //if i put collect outside LEf it will recollect with every fun recomposition
    //here it will collect only with first composition or key changed
    LaunchedEffect(key1 = true){
        viewModel.sharedFlow.collect { event ->
            when(event){
                is ScreenEvent.Navigate -> TODO()
                is ScreenEvent.ShowMessage -> TODO()
            }
        }
    }
}