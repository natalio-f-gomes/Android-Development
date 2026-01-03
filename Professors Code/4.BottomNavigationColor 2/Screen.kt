package com.example.bottomnavigationcolor

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Home Screen",
            style = MaterialTheme.typography.headlineMedium,
            color = bottomItem.getOrNull(0)?.color?: Color.Black
        )
    }
}
@Composable
fun MenuScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Menu Screen",
            style = MaterialTheme.typography.headlineMedium,
            color = bottomItem.getOrNull(1)?.color?: Color.Black
        )
    }
}
@Composable
fun AccountScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Account Screen",
            style = MaterialTheme.typography.headlineMedium,
            color = bottomItem.getOrNull(2)?.color?: Color.Black
        )
    }
}
@Composable
fun RewardsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Rewards Screen",
            style = MaterialTheme.typography.headlineMedium,
            color = bottomItem.getOrNull(3)?.color?: Color.Black
        )
    }
}
@Composable
fun CartScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Cart Screen", style = MaterialTheme.typography.headlineMedium,
            color = topItem.getOrNull(0)?.color?: Color.Black
        )
    }
}
@Composable
fun SettingsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Settings Screen",
            style = MaterialTheme.typography.headlineMedium,
            color = topItem.getOrNull(1)?.color?: Color.Black
        )
    }
}
