package nith.daily.cmp_learning.ui.day8

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import nith.daily.cmp_learning.ui.theme.ReplyTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute


@Serializable
object  HomeScreen

@Serializable
data class DeeplinkScreen(val id:Int)

@Composable
fun TypeSafeScreen() {
    ReplyTheme{
        Scaffold { innerPadding ->
            val navController = rememberNavController()
            NavHost(navController = navController,
                startDestination = HomeScreen,
                modifier = Modifier.padding(innerPadding)){
                composable < HomeScreen>{
                    TypeHomeScreen()
                }
                composable < DeeplinkScreen>(
                    deepLinks = listOf(
                        navDeepLink<DeeplinkScreen>(
                            basePath = "https://pl-coding.com"
                        )
                    )
                ){
                    val id = it.toRoute<DeeplinkScreen>().id
                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center){
                        Text(text = "The id is $id")
                    }
                }
            }
        }
    }

}

@Composable
fun TypeHomeScreen(modifier: Modifier = Modifier){
    val context = LocalContext.current
    var hasPermission by remember {
        mutableStateOf(Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU || ContextCompat.checkSelfPermission(context,
            Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED)
    }

    val permissionLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) {isGranted ->
        hasPermission = isGranted
    }

    Box(modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        if (!hasPermission && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            Button(onClick = {
                permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }) {
                Text(text = "Request permission")
            }
        } else{
            Text(text = "Home Screen")
        }
    }
}