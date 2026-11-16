package nith.daily.cmp_learning.ui.day6.weatherApp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import nith.daily.cmp_learning.data.Weather
import nith.daily.cmp_learning.data.repository.WeatherRepository

@Composable
fun WeatherScreen(
    repository: WeatherRepository = WeatherRepository()
) {

    var city by remember {
        mutableStateOf("")
    }

    var searchedCity by remember {
        mutableStateOf("Bangalore")
    }

    val coroutineScope = rememberCoroutineScope()
    LifecycleLogger()
    val weatherState by produceState<Weather?>(
        initialValue = null,
        searchedCity
    ) {
        value = repository.getWeather(searchedCity)
    }

    val weatherCategory by remember(weatherState) {
        derivedStateOf {

            when {
                weatherState == null -> ""
                weatherState!!.temperature > 30 -> "Hot"
                weatherState!!.temperature > 20 -> "Warm"
                else -> "Cold"
            }
        }
    }

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .padding(16.dp)
    ) {

        OutlinedTextField(
            value = city,
            onValueChange = {
                city = it
            },
            label = {
                Text("Search City")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = {
                coroutineScope.launch {
                    searchedCity = city
                }
            }
        ) {
            Text("Search")
        }

        Spacer(Modifier.height(20.dp))

        weatherState?.let { weather ->
            if (weather.temperature > 35) {

                WeatherAlert(
                    message = "Heat warning in ${weather.city}"
                )
            }
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = weather.city,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Text(
                        text = "${weather.temperature} °C"
                    )

                    Text(
                        text = weather.condition
                    )

                    Text(text = weatherCategory, color = Color.Blue)
                }
            }
        }
    }
}