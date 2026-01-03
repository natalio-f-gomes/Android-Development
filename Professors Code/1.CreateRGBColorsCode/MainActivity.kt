package com.example.creatergbcolors

import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.creatergbcolors.ui.theme.CreateRGBColorsTheme
import androidx.core.graphics.toColorInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            CreateRGBColorsTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    RGB()
                }
            }
        }
    }
}

/*
// From an Activity
// this means current Activity
Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show()

// In Jetpack Compose
// "this" doesn't work, so use "context" - kind of hook between your page and Android system
val context = LocalContext.current
Toast.makeText(context, "Message Here", Toast.LENGTH_SHORT).show()
 */
@Composable
fun RGB() {
    val keyboard = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    var redChannel by remember { mutableStateOf(TextFieldValue("")) }
    var greenChannel by remember { mutableStateOf(TextFieldValue("")) }
    var blueChannel by remember { mutableStateOf(TextFieldValue("")) }

    var displayColor by remember { mutableStateOf(Color.Transparent) }
    var displayText by remember { mutableStateOf("Create RGB Color") }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create an RGB Color",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Blue,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Add two hexadecimal characters between 0-9, A-F or a-f without the '#' for each channel",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        // Just for fun :-)
        OutlinedTextField(
            value = redChannel,
            onValueChange = { redChannel = it },
            label = { Text("Red Channel") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = greenChannel,
            onValueChange = { greenChannel = it },
            label = { Text("Green Chanel") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = blueChannel,
            onValueChange = { blueChannel = it },
            label = { Text("Blue Channel") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            onClick = {
                keyboard?.hide()  // This will hide keyboard

                val red = redChannel.text.trim()
                val green = greenChannel.text.trim()
                val blue = blueChannel.text.trim()
                Log.d("CreateRGBColor","got here")
                //if (red.isNotEmpty() && green.isNotEmpty() && blue.isNotEmpty()) {
                    try {
                        val colorHex = "#${red}${green}${blue}".toColorInt()
                        displayColor = Color(colorHex)
                        displayText = "Hex Color Created"
                    } catch (e: IllegalArgumentException) {
                        displayColor = Color.Transparent // just in case
                        //displayText = "Please enter hex colors: from 00 to FF."
                        Toast.makeText(context, "Please enter hex colors: from 00 to FF.", Toast.LENGTH_LONG).show()

                    }
                //}
            }
        ) {
            Text("Create RGB Color")
        }
        // Box has Only rectangular — doesn’t have shape handling (use Surface for different shape)
        Box(modifier = Modifier.fillMaxWidth().height(36.dp).background(displayColor),
            contentAlignment = Alignment.Center) {
            Text(
                text = displayText,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        /*
        Spacer(modifier = Modifier.height(16.dp))
        // Surface does not have alignment handling
        Surface(modifier = Modifier.fillMaxWidth().height(36.dp),
            shape = CircleShape, color = displayColor) {
            Text(
                text = "   $displayText",
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                style = MaterialTheme.typography.bodyLarge
            )
        }*/
    }
}
