package nith.daily.cmp_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nith.daily.cmp_learning.ui.day1.BirthdayCardScreen
import nith.daily.cmp_learning.ui.day1.BusinessCardScreen
import nith.daily.cmp_learning.ui.day1.ComposeArticleScreen
import nith.daily.cmp_learning.ui.day1.ComposeQuadrantScreen
import nith.daily.cmp_learning.ui.day1.TaskCompletedScreen
import nith.daily.cmp_learning.ui.day1.TipTimeScreen
import nith.daily.cmp_learning.ui.theme.CMP_LearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CMP_LearningTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
//                        ComposeTutorialDesign()
                        TipTimeScreen(innerPadding)
                       /* BirthdayCardScreen(
                            stringResource(R.string.happy_birthday_text),
                            stringResource(R.string.from_text),
                            modifier = Modifier.padding(8.dp)
                        )*/
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CmpLearningPreview() {
    CMP_LearningTheme {
        /*BirthdayCardScreen("Happy Birthday Nitheesh","From Emma", PaddingValues())
        ComposeArticleScreen(innerPadding = PaddingValues())
        TaskCompletedScreen(PaddingValues())
        BusinessCardScreen(PaddingValues())
        ComposeQuadrantScreen(PaddingValues())*/
        TipTimeScreen(PaddingValues())
    }
}