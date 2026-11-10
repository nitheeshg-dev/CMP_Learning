package nith.daily.cmp_learning.ui.day1

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nith.daily.cmp_learning.R
import kotlin.collections.get

@Composable
fun WoofScreen(innerPadding: PaddingValues) {
    val dogs = listOf(
        Dog(
            "Koda",
            2,
            R.drawable.karsten,
            "Enjoys playing with toys."
        ),
        Dog(
            "Lola",
            16,
            R.drawable.tanaphong,
            "Loves sleeping all day."
        ),
        Dog(
            "Frankie",
            2,
            R.drawable.sandro,
            "Likes running in the park."
        ),
        Dog(
            "Nox",
            8,
            R.drawable.katie,
            "Enjoys playing fetch."
        ),
        Dog(
            "Faye",
            8,
            R.drawable.karsten,
            "Loves chewing treats."
        ),
        Dog(
            "Bella",
            14,
            R.drawable.tanaphong,
            "Enjoys relaxing indoors."
        ),
        Dog(
            "Moana",
            2,
            R.drawable.sandro,
            "Likes swimming."
        ),
        Dog(
            "Tzeitel",
            7,
            R.drawable.katie,
            "Enjoys digging holes."
        )
    )
    LazyColumn(contentPadding = innerPadding) {
        items(dogs.size) {
            DogItem(
                dog = dogs[it],
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}
data class Dog(
    val name: String,
    val age: Int,
    val imageResourceId: Int,
    val description:String
)


@Composable
fun DogIcon(@DrawableRes dogIcon: Int,
            modifier: Modifier = Modifier){
    Image(
        painter = painterResource(dogIcon),
        contentDescription = null,
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .clip(MaterialTheme.shapes.small)
        , contentScale = ContentScale.Crop
    )
}


@Composable
fun DogItem(
    dog: Dog,
    modifier: Modifier = Modifier
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(bottomStart = 16.dp, topEnd = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                DogIcon(dog.imageResourceId)

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = dog.name,
                        style = MaterialTheme.typography.displayMedium,
                        modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
                    )
                    Text(
                        text = stringResource(R.string.years_old, dog.age),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                IconButton(
                    onClick = {
                        expanded = !expanded
                    }
                ) {
                    Icon(
                        imageVector = if (expanded)
                            Icons.Filled.KeyboardArrowUp
                        else
                            Icons.Filled.KeyboardArrowDown,
                        contentDescription = if (expanded)
                            "Collapse"
                        else
                            "Expand"
                    )
                }
            }

            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "About",
                    style = MaterialTheme.typography.titleSmall
                )

                Text(
                    text = dog.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}