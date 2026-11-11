package nith.daily.cmp_learning.ui.day1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nith.daily.cmp_learning.R
import nith.daily.cmp_learning.data.ArtworkDetails

@Composable
fun ArtSpaceScreen(innerPadding: PaddingValues) {
    val artworks = listOf(
        ArtworkDetails(
            R.drawable.blue_hills,
            "Blue Hills",
            "Jane Doe",
            "2021"
        ),
        ArtworkDetails(
            R.drawable.cosmic_stockcake,
            "Cosmic Dawn",
            "ArtSpace AI",
            "2024"
        ),
        ArtworkDetails(
            R.drawable.historical,
            "The Quiet Studio",
            "Alexei Leonov",
            "1965"
        )
    )

    var currentIndex by remember { mutableIntStateOf(0) }

    val artwork = artworks[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f).padding(bottom = 60.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = artwork.imageRes),
                    contentDescription = artwork.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(0.85f),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFECEAF0)
            )
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = artwork.title,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Light
                )

                Text(
                    buildAnnotatedString {
                        withStyle(
                            SpanStyle(fontWeight = FontWeight.Bold)
                        ) {
                            append(artwork.artist)
                        }
                        withStyle(SpanStyle(fontWeight = FontWeight.Normal)
                        ){
                            append(" (${artwork.year})")
                        }
                    },
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(
                onClick = {
                    currentIndex =
                        if (currentIndex > 0) currentIndex - 1
                        else artworks.lastIndex
                },
                modifier = Modifier.width(140.dp)
            ) {
                Text("Previous")
            }

            Button(
                onClick = {
                    currentIndex =
                        if (currentIndex < artworks.lastIndex)
                            currentIndex + 1
                        else 0
                },
                modifier = Modifier.width(140.dp)
            ) {
                Text("Next")
            }
        }
    }
}