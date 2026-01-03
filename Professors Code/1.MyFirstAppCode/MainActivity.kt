package com.example.myfirstapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.myfirstapp.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            MyFirstAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GreetingScreen()
                }
            }
        }
    }
}

@Composable
fun GreetingScreen() {
    /*
    Jetpack observe MutableStateOf() holder. If the value changes, jetpack redraws it”
    Without "remember", every time the UI recomposes, firstName, lastName would reset to default value
    We want to keep(remember) the current value, not default value
    */
    /* You may remove "by". This is just syntactic sugar to access .value automatically.
    var firstName = remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = firstName.value,
            onValueChange = { firstName.value = it },
        )
     */
    var firstName by remember { mutableStateOf(TextFieldValue("")) }
    var lastName by remember { mutableStateOf(TextFieldValue("")) }
    var greetingText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "MyFirstApp",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Blue,
            //color = DarkColorScheme.primary,
            fontWeight = FontWeight.Bold
        )
        // Empty space layout
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth()
        )
        // Empty space layout
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val first = firstName.text.trim()
                val last = lastName.text.trim()
                Log.d("MyFirstApp","Debug: view --> Tool Windows --> LogCat")

                greetingText = if (first.isNotEmpty() && last.isNotEmpty()) {
                    "Welcome to my first app, $first $last!"
                } else {
                    "Please enter a name."
                }
            }
        ) {
            Text("Enter")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = greetingText,
            color = Color.Magenta,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}