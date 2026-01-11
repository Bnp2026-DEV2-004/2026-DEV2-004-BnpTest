package net.BnpTestApp.domain.TicTacToe.usecase

import net.BnpTestApp.domain.TicTacToe.repo.GamesRepo

class ObserveCurrentGameUseCase(
    private val gamesRepo: GamesRepo
) {

    operator fun invoke() = gamesRepo.observeCurrentTicTacToeGame()

}