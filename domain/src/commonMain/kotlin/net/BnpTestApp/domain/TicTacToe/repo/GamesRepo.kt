package net.BnpTestApp.domain.TicTacToe.repo

import kotlinx.coroutines.flow.Flow
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeGame

interface GamesRepo {

    suspend fun getCurrentTicTacToeGame(): TicTacToeGame

    suspend fun publishUpdatedGame(updatedGame: TicTacToeGame)

    fun observeCurrentTicTacToeGame(): Flow<TicTacToeGame>

}