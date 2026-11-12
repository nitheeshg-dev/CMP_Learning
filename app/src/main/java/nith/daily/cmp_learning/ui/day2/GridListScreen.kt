package nith.daily.cmp_learning.ui.day2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nith.daily.cmp_learning.R
import nith.daily.cmp_learning.data.Topic
import nith.daily.cmp_learning.ui.theme.CoursesTheme

val topics = listOf(
    Topic(R.string.architecture, 58, R.drawable.architecture),
    Topic(R.string.crafts, 121, R.drawable.crafts),
    Topic(R.string.business, 78, R.drawable.business),
    Topic(R.string.culinary, 118, R.drawable.culinary),
    Topic(R.string.design, 423, R.drawable.design),
    Topic(R.string.fashion, 92, R.drawable.fashion),
    Topic(R.string.film, 165, R.drawable.film),
    Topic(R.string.gaming, 164, R.drawable.gaming),
    Topic(R.string.drawing, 326, R.drawable.drawing),
    Topic(R.string.lifestyle, 305, R.drawable.lifestyle),
    Topic(R.string.music, 212, R.drawable.music),
    Topic(R.string.painting, 172, R.drawable.painting),
    Topic(R.string.photography, 321, R.drawable.photography),
    Topic(R.string.tech, 118, R.drawable.tech)
)
@Composable
fun GridViewScreen(modifier: Modifier= Modifier){
    CoursesTheme(darkTheme = true, dynamicColor = true) {
        Scaffold(modifier = Modifier.fillMaxSize().statusBarsPadding(),
            containerColor = MaterialTheme.colorScheme.background) { innerPadding ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
                modifier = modifier.padding(8.dp),
                contentPadding = innerPadding
            ) {
                val result = topics + topics
                items(items =result, key = {}) { topic ->
                    GridCard(topic)
                }
            }
        }
    }

}


//@Preview(showBackground = true)
@Composable
fun GridPreview() {
    GridViewScreen()
}

@Composable
fun GridCard(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    val paddingSmall = dimensionResource(R.dimen.padding_small)
    val paddingMedium = dimensionResource(R.dimen.padding_medium)

    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(topic.icon),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(68.dp)
            )

            Column {
                Text(
                    text = stringResource(topic.title),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        start = paddingMedium,
                        top = paddingMedium,
                        end = paddingMedium,
                        bottom = paddingSmall
                    )
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = paddingMedium)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null
                    )

                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = paddingSmall)
                    )
                }
            }
        }
    }
}