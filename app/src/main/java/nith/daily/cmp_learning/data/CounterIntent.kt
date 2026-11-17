package nith.daily.cmp_learning.data

sealed interface CounterIntent {

    data object Increment : CounterIntent

    data object Decrement : CounterIntent
}