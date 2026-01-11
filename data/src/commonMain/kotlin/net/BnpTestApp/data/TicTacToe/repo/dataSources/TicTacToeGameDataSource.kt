package net.BnpTestApp.data.TicTacToe.repo.dataSources

import kotlinx.coroutines.flow.MutableSharedFlow
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeGame

class TicTacToeGameDataSource {

    private var ticTacToeGame = TicTacToeGame()

    private val mutableShareFlow = MutableSharedFlow<TicTacToeGame>(1)

    init {
        mutableShareFlow.tryEmit(ticTacToeGame)
    }

    fun getTicTacToeGameStateFlow() = mutableShareFlow

    suspend fun updateTicTacToeGame(ticTacToeGame: TicTacToeGame) {
        this.ticTacToeGame = ticTacToeGame
        mutableShareFlow.emit(this.ticTacToeGame)
    }

    suspend fun getCurrentTicTacToeGame(): TicTacToeGame {
        return ticTacToeGame
    }
}