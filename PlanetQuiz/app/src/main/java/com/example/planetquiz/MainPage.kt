package com.example.planetquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planetquiz.ui.theme.PlanetQuizTheme
@Composable
fun MainPage(){
    val navHostController = rememberNavController()
    var quizIndex = 0

    NavHost(
        navController = navHostController,
        startDestination = "mainPage"
    ){
        composable("mainPage") {
            QuizzesSection(quizIndex = {
                index -> quizIndex = index
                navHostController.navigate("quizPage")
            })
        }
        composable("quizPage")
        {
            QuizPage(index = quizIndex, onBack = {navHostController.popBackStack()})
        }
    }
}