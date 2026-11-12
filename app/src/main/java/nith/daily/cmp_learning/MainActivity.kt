package nith.daily.cmp_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nith.daily.cmp_learning.ui.day2.AffirmationsApp
import nith.daily.cmp_learning.ui.day3.DessertClickerScreen
import nith.daily.cmp_learning.ui.day3.StartedAppScreen
import nith.daily.cmp_learning.ui.theme.CMP_LearningTheme
import nith.daily.cmp_learning.ui.theme.DessertClickerTheme
import nith.daily.cmp_learning.ui.theme.UnscrambleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DessertClickerTheme {
                DessertClickerScreen()
            }
//            BasicLearningTheme()


        }
    }
}

@Composable
fun BasicLearningTheme(){
    CMP_LearningTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//            AffirmationsApp(innerPadding)

            /*Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                ArtSpaceScreen(innerPadding = innerPadding)
                 BirthdayCardScreen(
                stringResource(R.string.happy_birthday_text),
                stringResource(R.string.from_text),
                modifier = Modifier.padding(8.dp),
                     innerPadding = innerPadding
                )

            }*/
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun CmpLearningPreview() {
    BasicLearningTheme()
}