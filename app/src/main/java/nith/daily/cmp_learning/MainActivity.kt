package nith.daily.cmp_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nith.daily.cmp_learning.ui.day1.ArtSpaceScreen
import nith.daily.cmp_learning.ui.day1.BirthdayCardScreen
import nith.daily.cmp_learning.ui.day1.SuperHeroTopBar
import nith.daily.cmp_learning.ui.day1.SuperHeroesScreen
import nith.daily.cmp_learning.ui.day1.WoofScreen
import nith.daily.cmp_learning.ui.day1.WoofTopAppBar
import nith.daily.cmp_learning.ui.theme.CMP_LearningTheme
import nith.daily.cmp_learning.ui.theme.SuperheroesTheme
import nith.daily.cmp_learning.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SupperHeroScreenCall()
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
            Surface(
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
            }
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