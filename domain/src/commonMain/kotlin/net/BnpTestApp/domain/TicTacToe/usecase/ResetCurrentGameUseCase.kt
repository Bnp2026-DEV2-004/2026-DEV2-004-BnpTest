package net.BnpTestApp.domain.TicTacToe.usecase

import net.BnpTestApp.domain.TicTacToe.repo.GamesRepo

class ResetCurrentGameUseCase(
    private val gamesRepo: GamesRepo
) {

    suspend operator fun invoke() {
        gamesRepo.resetCurrentGame()
    }
}