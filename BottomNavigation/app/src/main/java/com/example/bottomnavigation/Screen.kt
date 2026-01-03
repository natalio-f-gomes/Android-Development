package com.example.bottomnavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Home Screen",
            style = MaterialTheme.typography.headlineMedium,
            color = bottomItem[0].color
        )
    }
}
@Composable
fun MenuScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Menu Screen",
            style = MaterialTheme.typography.headlineMedium,
            color = bottomItem[1].color
        )
    }
}
@Composable
fun AccountScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Account Screen",
            style = MaterialTheme.typography.headlineMedium,
            color = bottomItem[2].color
        )
    }
}
@Composable
fun RewardsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Rewards Screen",
            style = MaterialTheme.typography.headlineMedium,
            color = bottomItem[3].color
        )
    }
}
@Composable
fun CartScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Cart Screen", style = MaterialTheme.typography.headlineMedium,
            color = topItem[0].color
        )
    }
}
@Composable
fun SettingsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Settings Screen",
            style = MaterialTheme.typography.headlineMedium,
            color = topItem[1].color
        )
    }
}
