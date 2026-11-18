package nith.daily.cmp_learning

//import nith.daily.cmp_learning.ui.day7.mvvm_ui.CounterScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import nith.daily.cmp_learning.ui.day8.ExoplayerScreen
import nith.daily.cmp_learning.ui.theme.ReplyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /*ReplyTheme {
//                ReplyApp(windowSize = windowSize.widthSizeClass)

            }*/
            ReplyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ExoplayerScreen(modifier = Modifier.fillMaxSize().padding(innerPadding))
                }

            }
        }
    }
}