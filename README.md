# Side_Effects
<h3>Effect Handlers with Jetpack compose.</h3>
<h4>This example show eight effects handlers and their UseCases</h4>
<h3> Effect : <h2> 
<h3> Anything that escapes the scope of the composable function. </h3>

- **Launched Effect** trigger on first composition or key changed , when key value changed the launched effect will be cancelled and relaunched
- **Side Effect** it will be triggered on every recomposition
- **rememberCoroutineScope** trigger on first composition . it will provide a coroutine scope, where we can launch it anytime we like. Used in callbacks (e.g : onClick() ) 
- **DisposableEffect** it's like Launched Effect in addition to i can aware of when it terminate through onDispose() function (used with effects that require cleanup)
- **produceState** it is like Disposable state  +  if we want to trigger a recomposition, we need to change a Mutable State variable that is declared external to it.
- **derivedStateOf**  the recomposition will only be happened when the state value changed.
- **rememberUpdatedState**  if a state variable is updated, the side effect will get the latest state variable change.
- **snapshotFlow** trigger on value changed and produce kotlin flow , We can use this within a side effect e.g. LaunchedEffect.
