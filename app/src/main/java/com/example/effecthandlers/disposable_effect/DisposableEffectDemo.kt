package com.example.effecthandlers.disposable_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver

//it like LEf (trigger on first composition or key changed),
// but i can aware of when it terminate through onDispose() fun,
// so if i have some objects to be cleaned after finished or another scenario i can use it
@Composable
fun DisposableEffectDemo() {

    val lifecycleOwner = LocalLifecycleOwner.current
    /**
    //the following code has 2 issues
    //first we declare (observer) inside compo.fun so it will re-declared with every single recomposition
    //we shouldn't use LEF as the observer need to be cleaned up after used , we don't need it anymore(so we need dispose it)
    val observer = LifecycleEventObserver{ _, event ->
        if (event == Lifecycle.Event.ON_PAUSE){
            println("On Pause called")
        }
    }
    */
    
    DisposableEffect(key1 = lifecycleOwner ){
        val observer = LifecycleEventObserver{ _, event ->
            if (event == Lifecycle.Event.ON_PAUSE){
                println("On Pause called")
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        //clean up the observer when terminated
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

}