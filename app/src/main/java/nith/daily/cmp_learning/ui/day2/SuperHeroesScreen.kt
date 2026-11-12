package nith.daily.cmp_learning.ui.day2

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nith.daily.cmp_learning.R
import nith.daily.cmp_learning.data.Hero
import nith.daily.cmp_learning.ui.theme.SuperheroesTheme

val heroes = listOf(
    Hero(
        nameRes = R.string.hero1,
        descriptionRes = R.string.description1,
        imageRes = R.drawable.android_superhero1
    ),
    Hero(
        nameRes = R.string.hero2,
        descriptionRes = R.string.description2,
        imageRes = R.drawable.android_superhero2
    ),
    Hero(
        nameRes = R.string.hero3,
        descriptionRes = R.string.description3,
        imageRes = R.drawable.android_superhero3
    ),
    Hero(
        nameRes = R.string.hero4,
        descriptionRes = R.string.description4,
        imageRes = R.drawable.android_superhero4
    ),
    Hero(
        nameRes = R.string.hero5,
        descriptionRes = R.string.description5,
        imageRes = R.drawable.android_superhero5
    ),
    Hero(
        nameRes = R.string.hero6,
        descriptionRes = R.string.description6,
        imageRes = R.drawable.android_superhero6
    )
)

@Composable
fun SuperHeroesScreen(innerPadding: PaddingValues) {
    LazyColumn(contentPadding = innerPadding) {
        items(items = heroes, key = {}) {
            HeroItem(
                hero = it,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun HeroItem(hero:Hero, modifier: Modifier = Modifier){
    Card(modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Row(modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically) {
            HeroInformation(hero.nameRes, hero.descriptionRes, Modifier.weight(1f))
            Spacer(Modifier.width(16.dp))
            HeroLogo(hero.imageRes, modifier = Modifier)
        }
    }
}


@Composable
fun HeroInformation(@StringRes name:Int, @StringRes desc:Int, modifier: Modifier = Modifier){
    Column(modifier = modifier) {
        Text(text = stringResource(name),
            style = MaterialTheme.typography.displaySmall)
        Text(text = stringResource(desc),
            style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun HeroLogo(@DrawableRes heroLogo:Int, modifier: Modifier = Modifier){
    Box(modifier = modifier
        .padding(start = 16.dp)
        .size(72.dp)) {
        Image(
            painter = painterResource(heroLogo),
            contentDescription = null,
            Modifier.clip(RoundedCornerShape(8.dp)).
            fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroTopBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(R.string.super_hero_text),
            style = MaterialTheme.typography.displayLarge
        )
    },
        modifier = modifier)
}

//@Preview(showBackground = true)
@Composable
fun CmpLearningPreview() {

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