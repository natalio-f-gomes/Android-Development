package com.example.planetquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planetquiz.ui.theme.PlanetQuizTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizzesSection(quizIndex: (Int) -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Quizzes") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = padding
        ) {
            itemsIndexed(quizList) { index, individualQuiz ->
                Card(
                    modifier = Modifier.padding(8.dp).fillMaxWidth().clickable { quizIndex(index) }
                ) {
                    Row(modifier = Modifier.fillMaxWidth().padding(16.dp))
                    {
                        Text(text = individualQuiz.question)
                    }

                }
            }

        }
    }
}