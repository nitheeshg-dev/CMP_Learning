package nith.daily.cmp_learning.ui.day7.mvvm_ui
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
import nith.daily.cmp_learning.viewmodel.MvvmCounterViewModel

@Composable
fun CounterScreen(
    viewModel: MvvmCounterViewModel = viewModel(),
    paddingValues: PaddingValues
) {

    val count by viewModel.count.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(paddingValues)
    ) {

        Text(
            text = "Count : $count"
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.increment()
            }
        ) {
            Text("Increment")
        }
        Button(
            onClick = {
                viewModel.decrement()
            }
        ) {
            Text("Decrement")
        }
    }
}