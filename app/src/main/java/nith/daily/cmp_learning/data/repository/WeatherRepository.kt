package nith.daily.cmp_learning.data.repository

import android.util.Log
import kotlinx.coroutines.delay
import nith.daily.cmp_learning.data.Weather

class WeatherRepository {

    suspend fun getWeather(city: String): Weather {
        Log.d("tagOne -> ", "Calling API for $city")
        delay(2000)

        return Weather(
            city = city,
            temperature = (15..40).random().toDouble(),
            condition = listOf(
                "Sunny",
                "Cloudy",
                "Rainy"
            ).random()
        )
    }
}