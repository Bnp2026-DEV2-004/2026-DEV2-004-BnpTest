package net.BnpTestApp.data.TicTacToe.repo.dataSources

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeGame

class TicTacToeGameDataSource {

    private val mutableState = MutableStateFlow(TicTacToeGame())

    fun getTicTacToeGameStateFlow() = mutableState.asStateFlow()

    suspend fun updateTicTacToeGame(ticTacToeGame: TicTacToeGame) {
        mutableState.emit(ticTacToeGame)
    }

    suspend fun getCurrentTicTacToeGame(): TicTacToeGame {
        return mutableState.value
    }
}