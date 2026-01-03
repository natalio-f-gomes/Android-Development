package com.example.rainbow

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rainbow.ui.theme.RainbowTheme

class RainbowColorPickerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RainbowTheme {
                RainbowPicker(onColorSelected = { colorName, colorValue ->
                    val resultIntent = Intent().apply {
                        putExtra("RAINBOW_COLOR_NAME", colorName)
                        putExtra("RAINBOW_COLOR", colorValue)
                    }
                    setResult(RESULT_OK, resultIntent)
                    finish()
                })
            }
        }
    }
}

@Composable
fun RainbowPicker(onColorSelected: (String, Int) -> Unit) {
    val colors = mapOf<String, Color>(
        "Red" to Color.Red,
        "Orange" to Color(0xFFFFA500),  // ARGB (Alpha, Red, Green, Blue)
        "Yellow" to Color.Yellow,
        "Green" to Color.Green,
        "Blue" to Color.Blue,
        "Indigo" to Color(0xFF4B0082),
        "Violet" to Color(0xFF8F00FF)
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Which button is your favorite color of the rainbow?",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        colors.forEach { (name, color) ->
            Button(
                onClick = { onColorSelected(name, color.toArgb()) },
                colors = ButtonDefaults.buttonColors(containerColor = color),
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            ) {
                Text(name, color = Color.White)
            }
        }
    }
}
