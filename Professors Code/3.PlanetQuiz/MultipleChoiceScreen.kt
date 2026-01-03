package com.example.planetquiz

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultipleChoiceScreen(index: Int, onBack: () -> Unit) {
    val context = LocalContext.current

    val quest = quiz.getOrNull(index)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Back to Questions") },
                navigationIcon = {
                    IconButton(onClick = onBack) {  // IconButton displays a clickable icon
                        Icon(   // must provide an Icon composable and define the onClick lambda to handle the button press
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,  // <--
                            contentDescription = "Back" // This is for accessibility (screen readers for visually impaired users).
                        )
                    }
                }
            )
        }
    ) { padding ->
        if (quest == null) {
            Box(modifier = Modifier.fillMaxSize())
            {
                Text("Unknown Question")
            }
        } else {
            Column(
                modifier = Modifier.padding(24.dp).fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = quest.question)
                Spacer(modifier = Modifier.height(16.dp))
                choice.forEach { planet ->
                    Button(
                        onClick = {
                            if (planet==quest.answer)
                                Toast.makeText(context, "Correct", Toast.LENGTH_LONG).show()
                            else
                                Toast.makeText(context, "Incorrect The answer is ${quest.answer}", Toast.LENGTH_LONG).show()
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = planet)
                    }
                }

            }
        }
    }
}
