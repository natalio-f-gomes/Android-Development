package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworld.ui.theme.*
import com.example.helloworld.ui.theme.Pink40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // In Kotlin, the main() function is the starting point of execution.
        // In Android apps, the onCreate() function is the starting point of execution.
        super.onCreate(savedInstanceState)
        // Default style - configures the system bars with a transparent background
        enableEdgeToEdge()
        // The setContent() function is used to define your layout through composable functions.
        // This Composable function takes some input and generates what's shown on the screen.
        setContent {
            /*            //Original code
            HelloWorldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Dr. Jung",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }*/
            /*
            A Surface is a container that represents a section of UI
            Surround your text with a Surface
            where you can alter the appearance, such as the background color, border, etc.
             */
            HelloWorldTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Greeting(name="Dr. Jung")
                }
            }
        }
    }
}
/*
All functions marked with the @Composable annotation can be called from the setContent() function
or from other Composable functions.
The annotation tells the Kotlin compiler that this function is used by Jetpack to generate the UI.
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //Original code
    /*
    Text(
        text = "Hello $name!",
        modifier = modifier
    )*/
    // To surround the text with a Surface, highlight the line of text,
    // press (Alt+Enter for Windows or Option+Enter on Mac), and then
    // select "Surround with widget" and then select "Surround with Container"
    // The default container it will give you is Box,
    // you can change this to another container type. E.g, Surface

    //Surface (color = Color.Green){
    //Surface (color = Pink40){
    Surface (color = LightColorScheme.primary){ // import com.example.helloworld.ui.theme.* AND make the value not private
        Text(
            text = "Hello $name!",
            // A Modifier is used to augment or decorate a composable.
            // Modifier.padding() function adds space around the element
            // density independent-pixels. Android scales automatically based on the device's screen density.
            modifier = modifier.padding(96.dp),
            // MaterialTheme: access the current theme values. typography from Type.kt
            style = MaterialTheme.typography.titleLarge,
            color = Color.Green,
            textAlign = TextAlign.Center
        )
    }
}
/*
The GreetingPreview() function lets you see what your UI looks like without having to build your app.
To enable a preview of a composable, annotate with @Composable and @Preview.
The @Preview annotation tells Android Studio that this composable should be shown in the design view of this file.
If showBackground is set to true, it will add a background to your composable preview.
false means transparent
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldTheme {
        Greeting("Dr. Jung")
    }
}