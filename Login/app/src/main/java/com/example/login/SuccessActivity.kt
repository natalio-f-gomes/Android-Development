package com.example.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login.ui.theme.LoginTheme

class SuccessActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val username = intent.getStringExtra("USERNAME") ?: "User"

        setContent {
            LoginTheme {
                WelcomePage(
                    username = username,
                    onBackToLogin = {
                        // Send the username back to the MainActivity
                        val resultIntent = Intent().apply {
                            putExtra("USERNAME", username)
                        }
                        setResult(RESULT_OK, resultIntent)
                        finish()
                    }
                )
            }
        }
    }
}

@Composable
fun WelcomePage(username: String, onBackToLogin: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(12.dp))
        Text(
            text = "Welcome $username",
        )
        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = onBackToLogin) {
            Text(text = "Back to Login Page")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    LoginTheme {
        WelcomePage(username = "Preview User", onBackToLogin = {})
    }
}