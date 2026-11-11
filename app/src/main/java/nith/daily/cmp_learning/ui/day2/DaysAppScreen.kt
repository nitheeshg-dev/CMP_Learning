package nith.daily.cmp_learning.ui.day2

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nith.daily.cmp_learning.R
import nith.daily.cmp_learning.data.Day
import nith.daily.cmp_learning.ui.theme.DaysAppTheme


val days = listOf(
    Day(
        day = 1,
        title = R.string.fitness_title,
        description = R.string.fitness_desc,
        image = R.drawable.dayone
    ),
    Day(
        day = 2,
        title = R.string.recipes_title,
        description = R.string.recipes_desc,
        image = R.drawable.daytwo
    ),
    Day(
        day = 3,
        title = R.string.sewing_title,
        description = R.string.sewing_desc,
        image = R.drawable.daytwo
    )
)


@Composable
fun DaysAppScreen(innerPadding: PaddingValues) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = innerPadding
    ) {
        items(days.size) { day ->
            DayCard(days[day])
        }
    }
}

@Composable
fun DayCard(
    day: Day,
    modifier: Modifier = Modifier
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .animateContentSize()
            .clickable {
                expanded = !expanded
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Day ${day.day}",
                style = MaterialTheme.typography.displaySmall
            )

            Text(
                text = stringResource(day.title),
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = painterResource(day.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(day.description),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun daysTopBar(modifier: Modifier = Modifier){
    TopAppBar(title = {
        Text(
            text = stringResource(R.string.days_header_text),
            style = MaterialTheme.typography.displayLarge
        )
    },
        modifier = modifier)
}
@Preview(showBackground = true)
@Composable
fun DaysPreview() {

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