package com.example.starnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun StarSignApp() {
    /*
    Jetpack Navigation Compose to create a navigation flow between screens in an Android app.
    API NavHostController is for managing navigation between different screens.
    NavHostController is a subclass of NavController optimized for use within a NavHost composable.
    The "remember" part ensures that the same navController instance is preserved across UI recompositions (refreshes).
    This prevents losing the navigation state, such as the user's current screen or the back stack.
    Typically declare this in your main App composable and pass it to the NavHost and other composable functions
     */
    val navHostController = rememberNavController()
    var myIndex = 0

    // Provides a place in the Compose hierarchy/map
    NavHost(
        navController = navHostController,
        startDestination = "list"   // where to start
    ) {
        composable("list") {    // navigate function Navigate via the given NavDirections
            ListScreen(onStarClick = {
                index -> myIndex = index
                navHostController.navigate("detail")
            })
        }
        composable("detail")
        {
            DetailScreen(index = myIndex, onBack = { navHostController.popBackStack() })
            // popBackStack function pop the controller's back stack, back to a specific destination.
        }
    }
}
