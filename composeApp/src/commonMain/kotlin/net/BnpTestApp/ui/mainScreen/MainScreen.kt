package net.BnpTestApp.ui.mainScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Screens {
    WelcomeScreen,
    TicTacToeScreen
}

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screens.WelcomeScreen.name,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = Screens.WelcomeScreen.name) {
            Text("some text")
        }
        composable(route = Screens.TicTacToeScreen.name) {
            Text(" some other text")
        }
    }
}