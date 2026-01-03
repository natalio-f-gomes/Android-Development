package com.example.planetquiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizPage(index: Int, onBack:() -> Unit){
    val quiz = quizList.getOrNull(index)
    var userAnswer by remember { mutableStateOf("") }
    var message by remember {mutableStateOf("")}
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(quiz?.question ?: "Unknown") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ){
        padding ->
        Column(
            modifier = Modifier.padding(24.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
           choices.forEach { choice ->
               Button(
                   onClick = {
                       userAnswer = choice
                       if(userAnswer == quiz?.answer){
                           message = "Correct Answer"
                       }else{
                           message = "INCORRECT. The CORRECT answer is ${quiz?.answer}"
                       }
                   }
               ) {
                   Text(text = choice)
                   Spacer(modifier = Modifier.height(8.dp))
               }
           }


            if(message.isNotEmpty()){
                Text(message)
            }
        }
    }
}