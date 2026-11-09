package nith.daily.cmp_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nith.daily.cmp_learning.ui.theme.CMP_LearningTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CMP_LearningTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        ComposeTutorialDesign()

                        /*GreetingImage(
                            stringResource(R.string.happy_birthday_text),
                            stringResource(R.string.from_text),
                            modifier = Modifier.padding(8.dp)
                        )*/
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = message,
            fontSize = 90.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

//=================================================================
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        Greeting(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

//=================================================================

@Composable
fun ComposeTutorialDesign(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modifier) {
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

@Composable
fun ComposeTaskCompleted() {
    Column(
        modifier = Modifier.fillMaxSize(),
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
//==========================================================

@Composable
fun ComposeQuadrant() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            ListItem(
                title = "Text composable",
                description = "Displays text and follows Material Design guidelines.",
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFEADDFF))
            )

            ListItem(
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFD0BCFF))
            )
        }

        Row(
            modifier = Modifier.weight(1f)
        ) {
            ListItem(
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFB69DF8))
            )

            ListItem(
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFF6EDFF))
            )
        }
    }
}

@Composable
fun ListItem(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}


//=================================================================

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF84B29A))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Jennifer Doe",
                fontSize = 30.sp,
                color = Color.Black
            )

            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 18.sp,
                color = Color(0xFF176C39),
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            ContactInfo(
                icon = Icons.Default.Phone,
                text = "+11 (123) 444 555 666"
            )

            ContactInfo(
                icon = Icons.Default.Share,
                text = "@AndroidDev"
            )

            ContactInfo(
                icon = Icons.Default.Email,
                text = "jen.doe@android.com"
            )
        }
    }

}

@Composable
fun ContactInfo(
    icon: ImageVector,
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF176C39)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp
        )
    }
}
//========================================================

@Composable
fun TipTimeLayout() {

    var amountInput by remember { mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount = amount)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(value=amountInput, onValueChange = {amountInput = it}, modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth())
        Text(
            text = stringResource(R.string.tip_amount, "$0.00"),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}



@Composable
fun EditNumberField(value:String, onValueChange: (String) -> Unit, modifier: Modifier= Modifier ){

    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = {Text(stringResource(R.string.bill_amount))},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
    val tip = tipPercent / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showBackground = true)
@Composable
fun CmpLearningPreview() {
    CMP_LearningTheme {
//        ComposeTaskCompleted()
//        ComposeTutorialDesign()
//        ComposeQuadrant()
//        BusinessCard()
        TipTimeLayout()
//        Greeting("Happy Birthday Nitheesh","From Emma")
    }
}