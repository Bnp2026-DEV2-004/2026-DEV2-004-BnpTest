package net.BnpTestApp.domain.TicTacToe.usecase

import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeGame
import net.BnpTestApp.domain.TicTacToe.repo.GamesRepo

class PublishUpdatedGameUseCase(
    private val gamesRepo: GamesRepo
) {

    suspend operator fun invoke(updatedGame: TicTacToeGame) {
        gamesRepo.publishUpdatedGame(updatedGame)
    }
}