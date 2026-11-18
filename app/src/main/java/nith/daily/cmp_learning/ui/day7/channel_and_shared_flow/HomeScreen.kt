package nith.daily.cmp_learning.ui.day7.channel_and_shared_flow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import nith.daily.cmp_learning.viewmodel.LoginViewModel
import nith.daily.cmp_learning.viewmodel.NavigationEvent

@Composable
fun ChannelAndSharedFlowScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "login"){
        composable("login"){
            val viewModel = viewModel <LoginViewModel>()
            val state = viewModel.state
            ObserveAsEvent(viewModel.navigationEventChannelFlow, ){event ->
                when(event){
                    is NavigationEvent.NavigateToProfile -> {
                        navController.navigate("profile")
                    }
                     is NavigationEvent.CountEvent -> {
                         println("nitheeshmiasn -> count ${event.count}")
                     }
                }
            }
            /*LaunchedEffect(state.isLoggedIn) {
                if (state.isLoggedIn)
                    navController.navigate("profile")
            }*/
            LoginScreen(state= state, onLoginClick = viewModel::login)

        }
        composable("profile"){
            ProfileScreen()
        }

    }
}

@Composable
fun <T> ObserveAsEvent(flow: Flow<T>, onEvent :(T) ->Unit){
    val lifeCycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(flow, lifeCycleOwner.lifecycle) {
        lifeCycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
            withContext(Dispatchers.Main.immediate){
                flow.collect(onEvent)
            }
        }
    }
}