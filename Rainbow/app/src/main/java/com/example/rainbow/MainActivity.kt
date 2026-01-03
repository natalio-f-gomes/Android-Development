package com.example.rainbow

import android.graphics.Color.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rainbow.ui.theme.RainbowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            RainbowTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    PageNavigation()
                }
            }
        }
    }
}

@Composable
fun PageNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homepage"){
        composable("homepage") {
            MainPage(navController = navController)
        }
        composable("homepage/{favColor}/{hexColor}"){
            backStackEntry ->
            val favColorName = backStackEntry.arguments?.getString("favColor")
            val hexColor = backStackEntry.arguments?.getString("hexColor")
            (("hexColor"))
            MainPage(favColorName = favColorName, hexColor = hexColor, navController = navController)
        }
        composable("rainbowPage"){
                RainbowPage(navController = navController)
        }
    }
}

@Composable
fun MainPage(favColorName: String? = null, hexColor: String? = null, navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Please click the button below to choose your favorite color of the window!",
            fontWeight = FontWeight.Bold,
            color = Color(BLUE),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(

            onClick = {
                navController.navigate("rainbowPage")
            }
        ) {
            Text(
                text = "Pick your Rainbow Color"
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        if (!favColorName.isNullOrEmpty() && !hexColor.isNullOrEmpty()) {
            Box(
                modifier = Modifier.
                width(300.dp).
                background(Color(hexColor.toColorInt())).height(50.dp),
                contentAlignment = Alignment.Center
            )
            {
                Column(
                    modifier = Modifier.fillMaxSize().padding(10.dp),

                ) {
                    Text(
                        text = "$favColorName is your Favorite Color!",
                        color = Color.Black,
                        textAlign = TextAlign.Center,

                    )
                }
            }

        }else{
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
            ) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RainbowTheme {
        MainPage(navController = rememberNavController())
    }
}