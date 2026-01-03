package com.example.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector


data class Item(
    val title: String,
    val route: String,
    val icon: ImageVector,
    val color: Color
)

val bottomItem = listOf(
    Item("Home", "Home", Icons.Filled.Home, Color.Cyan),
    Item("Menu", "Menu", Icons.Filled.Fastfood, Color.Red),
    Item("Account", "Account", Icons.Filled.ManageAccounts, Color.Green),
    Item("Rewards", "Rewards", Icons.Filled.Star, Color.Green)
)

val topItem = listOf(
    Item("Cart", "Cart", Icons.Filled.AddShoppingCart, Color.Magenta),
    Item("Settings", "Settings", Icons.Filled.Build, Color.Yellow)
)


