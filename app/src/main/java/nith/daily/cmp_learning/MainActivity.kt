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
import nith.daily.cmp_learning.ui.day1.WoofScreen
import nith.daily.cmp_learning.ui.day1.WoofTopAppBar
import nith.daily.cmp_learning.ui.day2.AffirmationsApp
import nith.daily.cmp_learning.ui.day2.DaysAppScreen
import nith.daily.cmp_learning.ui.day2.GridViewScreen
import nith.daily.cmp_learning.ui.day2.SuperHeroTopBar
import nith.daily.cmp_learning.ui.day2.SuperHeroesScreen
import nith.daily.cmp_learning.ui.day2.daysTopBar
import nith.daily.cmp_learning.ui.theme.CMP_LearningTheme
import nith.daily.cmp_learning.ui.theme.DaysAppTheme
import nith.daily.cmp_learning.ui.theme.SuperheroesTheme
import nith.daily.cmp_learning.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GridViewScreen()
//            DaysScreenCall()
//            SupperHeroScreenCall()
//            WoofScreenCall()
//            BasicLearningTheme()
        }
    }
}

@Composable
fun WoofScreenCall(){
    WoofTheme {
        Scaffold(
            topBar = {
                WoofTopAppBar()
            }
        ) { it ->
            WoofScreen(it)
        }
    }
}

@Composable
fun DaysScreenCall() {
    DaysAppTheme(darkTheme = false, dynamicColor = true) {
        Scaffold(
            topBar = {
                daysTopBar()
            }
        ) { it ->
            DaysAppScreen(it)
        }
    }

}

@Composable
fun SupperHeroScreenCall(){
    SuperheroesTheme(darkTheme = false, dynamicColor = true) {
        Scaffold(
            topBar = {
                SuperHeroTopBar()
            }
        ) { it ->
            SuperHeroesScreen(it)
        }
    }
}

@Composable
fun BasicLearningTheme(){
    CMP_LearningTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            AffirmationsApp(innerPadding)
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

    WoofScreenCall()

}