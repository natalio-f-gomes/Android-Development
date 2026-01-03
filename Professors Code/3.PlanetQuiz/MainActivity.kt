package com.example.planetquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.planetquiz.ui.theme.PlanetQuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlanetQuizTheme {
                PlanetQuizApp()
            }
        }
    }
}
