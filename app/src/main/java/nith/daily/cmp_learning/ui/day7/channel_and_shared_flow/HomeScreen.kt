package nith.daily.cmp_learning.ui.day7.channel_and_shared_flow

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nith.daily.cmp_learning.viewmodel.MainViewModel

@Composable
fun ChannelAndSharedFlowScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "login"){
        composable("login"){
            val viewModel = viewModel <MainViewModel>()
            val state = viewModel.state



        }

    }
}