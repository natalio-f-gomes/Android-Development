package com.example.rgbapp

import android.R
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.rgbapp.ui.theme.RGBAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            RGBAppTheme {
                Surface(modifier = Modifier.fillMaxSize()){
                    DisplayRGB()
                }
            }
        }
    }
}

@Composable
fun DisplayRGB() {
    val keyboard = LocalSoftwareKeyboardController.current
    var rValue by remember { mutableStateOf(TextFieldValue("")) }
    var gValue by remember { mutableStateOf(TextFieldValue("")) }
    var bValue by remember { mutableStateOf(TextFieldValue("")) }
    var generateText by remember { mutableStateOf("") }
    var textColor: Int?  by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(46.dp))
        Text(
            text = "Welcome to RGB APP",
            style = MaterialTheme.typography.bodyLarge,
            color= Color.Blue,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text ="lorem fhladh",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(36.dp))
        TextField(
            value = rValue,
            onValueChange = {rValue = it},
            label = { Text("R Color")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(36.dp))
        TextField(
            value = gValue,
            onValueChange = {gValue = it},
            label = { Text("G Color")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(36.dp))
        TextField(
            value = bValue,
            onValueChange = {bValue = it},
            label = { Text("B Color")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(36.dp))
        Button(
            onClick = {
                keyboard?.hide()

                val rVal = rValue.text.trim()
                val gVal = gValue.text.trim()
                val bVal = bValue.text.trim()
                Log.d("rVal", rVal)
                Log.d("gVal", gVal)
                Log.d("bVal", bVal)
                try {
                    textColor = "#${rVal}${gVal}${bVal}".toColorInt()
                    generateText = "Hello world"
                }
                catch (e: IllegalArgumentException){
                    println(e)
                }



            }
        )
        {
            Text(
                text = "Display Color",
            )

        }

        Spacer(modifier = Modifier.height(36.dp))

        Box(
            modifier = Modifier.background(Color(textColor!!)),
            ) {
            Column(
                modifier = Modifier.fillMaxSize(),

            ) {
                Text(
                    text = generateText,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    textAlign = TextAlign.Center
                    )
            }
        }



    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RGBAppTheme {
        DisplayRGB()
    }
}
