package com.example.bottomnavigation

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationApp() {
    var menuExpanded by remember { mutableStateOf(false) }
    val navHostController = rememberNavController()

    // observe (highlight) the correct bottom navigation icon when the user switches screens.
    val currentScreen by navHostController.currentBackStackEntryAsState()

    // destination.route: the name of the route you navigated to (e.g., "home", "profile")
    val currentTitle = currentScreen?.destination?.route?: "Error"

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentTitle) },
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
                                leadingIcon = { Icon(topItem.icon, contentDescription = topItem.title) },
                                text = { Text(topItem.title) },
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
                        icon = { Icon(bottomItem.icon, contentDescription = bottomItem.title) },
                        label = { Text(bottomItem.title) },
                        // selected = true : the item is highlighted (you may have customized effect).
                        selected = currentScreen?.destination?.route == bottomItem.route,
                        onClick = {
                            navHostController.navigate(bottomItem.route)
                        }
                    )
                }
            }
        }
    ) { padding -> // "padding" (similar to "it") ensure that main content doesn't overlap with other UI (e.g.,TopAppBar)
        // Provides a place in the Compose hierarchy/map
        NavHost(
            navController = navHostController,
            startDestination = "home",
            modifier = androidx.compose.ui.Modifier.padding(padding)
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
