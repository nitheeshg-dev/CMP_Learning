package nith.daily.cmp_learning.ui.day1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nith.daily.cmp_learning.R

@Composable
fun TaskCompletedScreen(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val image = painterResource(R.drawable.ic_task_completed)
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.title_text),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.nice_work_text),
            fontSize = 16.sp
        )
    }

}