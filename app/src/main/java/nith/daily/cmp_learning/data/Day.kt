package nith.daily.cmp_learning.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Day(
    @StringRes val day: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)
