package nith.daily.cmp_learning.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val title: Int,
    val availableCourses:Int,
    @DrawableRes val icon: Int
)
