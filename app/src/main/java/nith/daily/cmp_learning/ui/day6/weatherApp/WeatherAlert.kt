package nith.daily.cmp_learning.ui.day6.weatherApp

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun WeatherAlert(message:String) {
    val currentMessage by rememberUpdatedState(
        newValue = message
    )
    LaunchedEffect(Unit) {
        delay(5000)
        Log.d("tagOne -> Alert message", currentMessage)
    }
}
