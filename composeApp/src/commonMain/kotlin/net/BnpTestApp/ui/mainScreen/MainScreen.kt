package net.BnpTestApp.ui.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
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
    viewModel: MainScreenViewModel = viewModel(factory = mainViewModelFactory),
    navController: NavHostController = rememberNavController()
) {

    LaunchedEffect(Unit) {
        viewModel.action.collect {
            navController.navigate(route = Screens.TicTacToeScreen.name)
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screens.WelcomeScreen.name,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = Screens.WelcomeScreen.name) {
            Text("some text",
                modifier = Modifier
                    .height(40.dp)
                    .background(Color.Red)
                    .clickable{
                        viewModel.handleEvent()
                    }
            )
        }
        composable(route = Screens.TicTacToeScreen.name) {
            Text("Tic Tac Toe Screen",
                modifier = Modifier
                    .height(200.dp)
                    .background(Color.Blue)
            )
        }
    }
}