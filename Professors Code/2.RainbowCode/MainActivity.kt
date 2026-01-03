package com.example.rainbow

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rainbow.ui.theme.RainbowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContent function is used to define your layout through composable functions.
        setContent {
            RainbowTheme {
                Rainbow()
            }
        }
    }

}
/*
An intent in Android is a communication mechanism between Activities
https://developer.android.com/reference/android/content/Intent
*/
@Composable
fun Rainbow() {
    var colorName by remember { mutableStateOf("") }
    var colorInt: Int? by remember { mutableStateOf(Color.White.toArgb()) } //  convert to RGB int.

    // Set the name of the Activity to launch (e.g., RainbowColorPickerActivity)
    val intent = Intent(LocalContext.current,RainbowColorPickerActivity::class.java)


    // This allows you start another activity (or request a permission, pick a file, take a photo, etc.)
    // and then handle the result (via lambda function result --> ...)
    // This is the Composable-specific equivalent of registerForActivityResult, designed for use within Jetpack Compose UI.
    // launcher.launch(intent)
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            colorName = result.data?.getStringExtra("RAINBOW_COLOR_NAME") ?: ""
            colorInt = result.data?.getIntExtra("RAINBOW_COLOR", Color.White.toArgb())
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Text(
            text = "Please click the button below to choose your favorite color of the rainbow!",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
       )
        Button(onClick = {
            launcher.launch(intent) // This know which page to go
        })
        {
            Text("Pick Your Rainbow Color")
        }

        if (colorName.isNotEmpty()) {
            Spacer(modifier = Modifier.height(32.dp))
            Box(modifier = Modifier.fillMaxWidth().height(36.dp).background(Color(colorInt!!)),
                contentAlignment = Alignment.Center){
                Text(
                    text = "$colorName is your favorite color!",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
