package com.example.planetquiz

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
import androidx.compose.ui.unit.dp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionScreen(onStarClick: (Int) -> Unit) {
    // Use Scaffold when we need to use TopAppBar, instead of Surface/Box/Card...
    Scaffold(
        topBar = {  // TopAppBar has slots for a title, navigation icon, and actions.
            TopAppBar(title = { Text("Planet Quiz") })
        }
    ) { padding ->  // "padding" (similar to "it") ensure that main content doesn't overlap with other UI (e.g.,TopAppBar)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = padding    //Add a padding before the first item (you could just use Modifier.padding(60.dp))
        ) { // itemsIndexed is a LazyColumn extension function to iterate over a list and access both the item and index
            itemsIndexed(quiz) { index, item ->
                Card(   // Card is similar to Surface and Box, just provide different UI
                    modifier = Modifier.padding(8.dp).fillMaxWidth().clickable { onStarClick(index) }
                ) {
                    Row(modifier = Modifier.fillMaxWidth().padding(16.dp),)
                    {
                        Text(text = item.question)
                    }
                }
            }
        }
    }
}