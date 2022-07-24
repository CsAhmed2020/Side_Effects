# Side_Effects
<h3>Effect Handlers with Jetpack compose.</h3>
<h4>This example show eight effects handlers and their UseCases</h4>
<h3> Effect : <h2> 
<h3> Anything that escapes the scope of the composable function. </h3>

- **Launched Effect** trigger on first composition or key changed , when key value changed the launched effect will be cancelled and relaunched
- **Side Effect** it will be triggered with every recomposition
- **rememberCoroutineScope** trigger on first composition , used in callbacks (like onClick)
- **DisposableEffect** it's like Launched Effect + i can aware of when it terminate through onDispose() function
- **produceState** it is like Disposable state  + it produce state value with remember
- **derivedStateOf**  the recomposition will only be happened when the state value changed.
- **rememberUpdatedState**  if a state variable is updated, the side effect will get the latest state variable change.
- **snapshotFlow** trigger on value changed and produce kotlin flow , We can use this within a side effect e.g. LaunchedEffect
