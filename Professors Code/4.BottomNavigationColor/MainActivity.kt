package com.example.bottomnavigationcolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bottomnavigationcolor.ui.theme.BottomNavigationColorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationColorTheme {
                BottomNavigationApp()
            }
        }
    }
}