package nith.daily.cmp_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nith.daily.cmp_learning.ui.day1.WoofScreen
import nith.daily.cmp_learning.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WoofTheme {
                Scaffold(
                    topBar = {
                        WoofTopAppBar()
                    }
                ) { it ->
                    WoofScreen(it)
                }
            }

            /*CMP_LearningTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        ArtSpaceScreen(innerPadding = innerPadding)
//                        ComposeTutorialDesign()
//                        TipTimeScreen(innerPadding)
                       *//* BirthdayCardScreen(
                            stringResource(R.string.happy_birthday_text),
                            stringResource(R.string.from_text),
                            modifier = Modifier.padding(8.dp)
                        )*//*
                    }
                }
            }*/
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.woof),

                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.woof_text),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun CmpLearningPreview() {
    /*CMP_LearningTheme {
        *//*BirthdayCardScreen("Happy Birthday Nitheesh","From Emma", PaddingValues())
        ComposeArticleScreen(innerPadding = PaddingValues())
        TaskCompletedScreen(PaddingValues())
        BusinessCardScreen(PaddingValues())
        ComposeQuadrantScreen(PaddingValues())*//*
//        TipTimeScreen(PaddingValues())
//        ArtSpaceScreen(PaddingValues())
//        WoofScreenChange()
    }*/

    WoofTheme(darkTheme = false, dynamicColor = true) {
        Scaffold(
            topBar = {
                WoofTopAppBar()
            }
        ) { it ->
            WoofScreen(it)
        }
    }

}