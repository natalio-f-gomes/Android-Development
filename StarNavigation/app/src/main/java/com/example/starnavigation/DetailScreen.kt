package com.example.starnavigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.rounded.ArrowRight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(index: Int, onBack: () -> Unit) {
    val sign = starSigns.getOrNull(index)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(sign?.name ?: "Unknown") },
                navigationIcon = {
                    IconButton(onClick = onBack) {  // IconButton displays a clickable icon
                        Icon(   // must provide an Icon composable and define the onClick lambda to handle the button press
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,  // <--
                            //imageVector = Icons.AutoMirrored.Default.ArrowForwardIos,  // >
                            //imageVector = Icons.AutoMirrored.Rounded.ArrowRight,  // >

                            contentDescription = "Back" // This is for accessibility (screen readers for visually impaired users).
                        )
                    }
                }
            )
        }
    ) { padding ->
            Column(
                modifier = Modifier.padding(24.dp).fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = sign?.name?:"Unknown Star Sign")
                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Symbol: ${sign?.symbol?:""}")
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Date Range: ${sign?.dateRange?:""}")
            }
    }
}
