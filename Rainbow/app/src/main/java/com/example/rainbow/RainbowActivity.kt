package com.example.rainbow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.rainbow.ui.theme.RainbowTheme
import android.graphics.Color.*
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


class RainbowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RainbowTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    RainbowPage()
                }
            }
        }
    }
}

@Composable
fun RainbowPage(favColor: Array<out String?>? = null, navController: NavHostController = rememberNavController()) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val colors = mapOf(
            "Red" to "#F44336",
            "Orange" to "#FF9800",
            "Yellow" to "#FFEB3B",
            "Green" to "#4CAF50",
            "Blue" to "#2196F3",
            "Indigo" to "#3F51B5",
            "Purple" to "#9C27B0"
        )
        Spacer(modifier =  Modifier.height(200.dp))
        Text(
            text = "Which button is your favorite color of the\nrainbow?",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier =  Modifier.height(10.dp))

        colors.forEach {
            (name, hexCode) ->
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(hexCode.toColorInt()),
                    contentColor = Color.White,

                ),
               modifier = Modifier.width(300.dp),
                onClick = {
                    val encodeHex = Uri.encode(hexCode)
                    navController.navigate("homepage/$name/$encodeHex"){
                        popUpTo ("homepage") {inclusive = false}
                        launchSingleTop = true
                    }
                }
            ){
                Text( text = name)
                Spacer(modifier =  Modifier.height(10.dp))
            }
            Spacer(modifier =  Modifier.height(10.dp))

        }

    }
}

@Preview(showBackground = true)
@Composable
fun RainbowPreview() {
    RainbowTheme {
        RainbowPage()
    }
}