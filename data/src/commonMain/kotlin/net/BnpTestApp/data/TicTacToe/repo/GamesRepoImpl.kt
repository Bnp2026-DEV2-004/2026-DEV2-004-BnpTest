package net.BnpTestApp.data.TicTacToe.repo

import kotlinx.coroutines.flow.Flow
import net.BnpTestApp.data.TicTacToe.repo.dataSources.TicTacToeGameDataSource
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeGame
import net.BnpTestApp.domain.TicTacToe.repo.GamesRepo

class GamesRepoImpl(
    private val ticTacToeGameDataSource: TicTacToeGameDataSource
): GamesRepo {

    override suspend fun getCurrentTicTacToeGame(): TicTacToeGame {
        return ticTacToeGameDataSource.getCurrentTicTacToeGame()
    }

    override suspend fun publishUpdatedGame(updatedGame: TicTacToeGame) {
        ticTacToeGameDataSource.updateTicTacToeGame(updatedGame)
    }

    override fun observeCurrentTicTacToeGame(): Flow<TicTacToeGame> {
        return ticTacToeGameDataSource.getTicTacToeGameStateFlow()
    }

    override suspend fun resetCurrentGame() {
        ticTacToeGameDataSource.updateTicTacToeGame(TicTacToeGame())
    }
}