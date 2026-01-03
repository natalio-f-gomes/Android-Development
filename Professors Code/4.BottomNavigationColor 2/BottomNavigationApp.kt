package com.example.bottomnavigationcolor

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationApp() {
    var menuExpanded by remember { mutableStateOf(false) }
    val navHostController = rememberNavController()

    // observe (highlight) the correct bottom navigation icon when the user switches screens.
    val currentScreen by navHostController.currentBackStackEntryAsState()

    // destination.route: the name of the route you navigated to (e.g., "home", "profile")
    val currentTitle = currentScreen?.destination?.route?: "Error"
    val items = bottomItem+topItem
    val currentColor = items.find{it -> currentScreen?.destination?.route == it.route}?.color?: Color.Black
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentTitle, color = currentColor) },
                actions = {
                    // Overflow menu button
                    IconButton(onClick = { menuExpanded = true }) {
                        Icon(Icons.Filled.Menu, contentDescription = "More...")
                    }
                    DropdownMenu(
                        expanded = menuExpanded,
                        onDismissRequest = { menuExpanded = false }
                    ) {
                        topItem.forEach {topItem ->
                            DropdownMenuItem(
                                leadingIcon = { Icon(topItem.icon, contentDescription = topItem.title, tint = topItem.color) },
                                text = { Text(topItem.title, color=topItem.color) },
                                onClick = {
                                    menuExpanded = false
                                    navHostController.navigate(topItem.route)
                                }
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                bottomItem.forEach { bottomItem ->
                    NavigationBarItem(
                        icon = { Icon(bottomItem.icon, contentDescription = bottomItem.title, tint=bottomItem.color) },
                        label = { Text(bottomItem.title, color=bottomItem.color) },
                        // selected = true : the item is highlighted (e.g. bold text, filled icon, or different color).
                        selected = currentScreen?.destination?.route == bottomItem.route,
                        onClick = {
                            navHostController.navigate(bottomItem.route)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = "home",
            modifier = androidx.compose.ui.Modifier.padding(innerPadding)
        ) {
            composable("Home") { HomeScreen() }
            composable("Menu") { MenuScreen() }
            composable("Account") { AccountScreen() }
            composable("Rewards") { RewardsScreen() }
            composable("Cart") { CartScreen() }
            composable("Settings") { SettingsScreen() }

        }
    }
}
