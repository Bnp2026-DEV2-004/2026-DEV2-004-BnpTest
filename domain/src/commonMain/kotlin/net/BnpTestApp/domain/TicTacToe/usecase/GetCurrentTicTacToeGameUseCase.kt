package net.BnpTestApp.domain.TicTacToe.usecase

import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeGame
import net.BnpTestApp.domain.TicTacToe.repo.GamesRepo

class GetCurrentTicTacToeGameUseCase(
    private val gamesRepo: GamesRepo
) {

    suspend operator fun invoke(): TicTacToeGame {
        return gamesRepo.getCurrentTicTacToeGame()
    }

}