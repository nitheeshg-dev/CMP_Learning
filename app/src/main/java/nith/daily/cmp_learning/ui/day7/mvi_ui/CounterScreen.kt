package nith.daily.cmp_learning.ui.day7.mvi_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import nith.daily.cmp_learning.data.CounterIntent
import nith.daily.cmp_learning.viewmodel.MviCounterViewModel

@Composable
fun CounterScreen(
    viewModel: MviCounterViewModel = viewModel(),
    paddingValues: PaddingValues
) {

    val uiState by
    viewModel.uiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(paddingValues)
    ) {

        Text(
            text = "Count : ${uiState.count}"
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.onIntent(
                    CounterIntent.Increment
                )
            }
        ) {
            Text("Increment")
        }
        Button(
            onClick = {
                viewModel.onIntent(
                    CounterIntent.Decrement
                )
            }
        ) {
            Text("Decrement")
        }
    }
}