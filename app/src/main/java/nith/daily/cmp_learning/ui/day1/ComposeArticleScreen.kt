package nith.daily.cmp_learning.ui.day1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nith.daily.cmp_learning.R

@Composable
fun ComposeArticleScreen(modifier: Modifier = Modifier, innerPadding: PaddingValues) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modifier.padding(innerPadding)) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.jetpack_compose_header),
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            fontSize = 16.sp,
            textAlign = TextAlign.Justify, text = stringResource(R.string.short_description_text),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            fontSize = 16.sp,
            textAlign = TextAlign.Justify, text = stringResource(R.string.long_description_text),
            modifier = Modifier.padding(16.dp)
        )
    }

}
