package com.example.planetquiz

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
@Composable
fun PlanetQuizApp(){
    val navHostController = rememberNavController()
    var myIndex = 0

    // Provides a place in the Compose hierarchy/map
    NavHost(
        navController = navHostController,
        startDestination = "question"   // where to start
    ) {
        composable("question") {    // navigate function Navigate via the given NavDirections
            QuestionScreen(onStarClick = { index -> myIndex = index; navHostController.navigate("choice") })
        }
        composable("choice")
        {
            MultipleChoiceScreen(index = myIndex, onBack = { navHostController.popBackStack() })
            // popBackStack function pop the controller's back stack, back to a specific destination.
        }
    }
}