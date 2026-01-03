package com.example.bottomnavigationcolor

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
    Item("Home", "Home", Icons.Filled.Home, Color(0xFF32cd32)),
    Item("Menu", "Menu", Icons.Filled.Fastfood, Color(0xFF800080)),
    Item("Account", "Account", Icons.Filled.ManageAccounts,Color.Blue),
    Item("Rewards", "Rewards", Icons.Filled.Star,Color.Red)
)

val topItem = listOf(
    Item("Cart", "Cart", Icons.Filled.AddShoppingCart, Color(0xFFb8860b)),
    Item("Settings", "Settings", Icons.Filled.Build,Color(0xFFa020f0))
)


