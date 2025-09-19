package com.example.headfirstkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.headfirstkotlin.ui.theme.HeadFirstKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemperatureConverter()
        }
    }
}


@Composable
fun TemperatureConverter() {
    Column(modifier = Modifier.padding(WindowInsets.statusBars.asPaddingValues())) {
        val temperatureValue = remember { mutableStateOf(0) }
        Header(R.drawable.ic_launcher_background, "image description")
        UserInput()
        ConvertButton({
            temperatureValue.value = temperatureValue.value + 1
        })
        OutputDisplay(temperatureValue.value)
    }
}

@Composable
fun Header(image: Int, description: String) {
    Image(
        painter = painterResource(image),
        contentDescription = description,
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
    )
}

@Composable
fun UserInput() {

}

@Composable
fun ConvertButton(clicked:() -> Unit = {}) {
    Button(onClick = clicked) {
        Text("Convert")
    }
}

@Composable
fun OutputDisplay(result: Int) {
    Text("Value of result is: $result")
}

@Preview(showBackground = true)
@Composable
fun PreviewUI() {
    TemperatureConverter()
}