package nith.daily.cmp_learning.ui.day7.channel_and_shared_flow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import nith.daily.cmp_learning.data.LoginSate

@Composable
fun LoginScreen(state: LoginSate,onLoginClick: () -> Unit) {
    Surface() {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                onLoginClick()
            }){
                Text(text = "Login Screen")
            }

        }
    }
}