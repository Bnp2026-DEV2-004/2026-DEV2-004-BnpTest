package net.BnpTestApp.ui.mainScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.BnpTestApp.designSystem.tokens.bnpTestAppTypography
import net.BnpTestApp.ui.ticTacToeGame.TicTacToeGameScreen

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

    MaterialTheme {
        NavHost(
            navController = navController,
            startDestination = Screens.WelcomeScreen.name,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(route = Screens.WelcomeScreen.name) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Button(
                        onClick = {},
                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        Text(
                            text = "Start Tic Tac Toe",
                            style = bnpTestAppTypography.h2,
                            modifier = Modifier.clickable{ viewModel.handleEvent() }
                        )
                    }
                }
            }
            composable(route = Screens.TicTacToeScreen.name) {
                TicTacToeGameScreen()
            }
        }
    }

}