package nith.daily.cmp_learning.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import nith.daily.cmp_learning.data.CounterIntent
import nith.daily.cmp_learning.data.CounterUiState

class MviCounterViewModel : ViewModel() {

    private val _uiState =
        MutableStateFlow(CounterUiState())

    val uiState =
        _uiState.asStateFlow()

    fun onIntent(
        intent: CounterIntent
    ) {
        println("nitheeshmiasns -> $intent")
        when(intent) {

            CounterIntent.Increment -> {

                _uiState.update {
                    it.copy(
                        count = it.count + 1
                    )
                }
            }

            CounterIntent.Decrement -> {

                _uiState.update {
                    it.copy(
                        count = it.count - 1
                    )
                }
            }
        }
    }
}