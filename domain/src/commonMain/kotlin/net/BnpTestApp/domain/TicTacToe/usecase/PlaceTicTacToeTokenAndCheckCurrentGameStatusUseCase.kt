package net.BnpTestApp.domain.TicTacToe.usecase

import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeGame

class PlaceTicTacToeTokenAndCheckCurrentGameStatusUseCase(
    private val placeTicTacToeTokenUseCase: PlaceTicTacToeTokenUseCase,
    private val checkAndUpdateGameStatusUseCase: CheckAndUpdateGameStatusUseCase,
    private val getCurrentTicTacToeGameUseCase: GetCurrentTicTacToeGameUseCase,
) {

    suspend operator fun invoke(
        rowIndex: Int,
        columnIndex: Int,
    ): TicTacToeGame {
        getCurrentTicTacToeGameUseCase().let { game ->
            placeTicTacToeTokenUseCase(rowIndex, columnIndex, game)
            return checkAndUpdateGameStatusUseCase(game)
        }
    }
}