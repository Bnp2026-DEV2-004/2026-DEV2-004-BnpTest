package net.BnpTestApp.domain.TicTacToe.usecase

import net.BnpTestApp.domain.TicTacToe.entities.GameStatus
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeGame

class CheckAndUpdateGameStatusUseCase(
    private val checkForWinnerUseCase: CheckForWinnerUseCase,
    private val checkIfBoardIsFullUseCase: CheckIfBoardIsFullUseCase
) {

    operator fun invoke(ticTacToeGame: TicTacToeGame): TicTacToeGame {
        checkForWinnerUseCase(ticTacToeGame.ticTacToeBoard)?.let { winner ->
            ticTacToeGame.gameStatus = GameStatus.CompletedWithWinner(winner)
        }
        if (ticTacToeGame.gameStatus !is GameStatus.CompletedWithWinner) {
            checkIfBoardIsFullUseCase(ticTacToeGame.ticTacToeBoard).let { boardIsFull ->
                if (boardIsFull) {
                    ticTacToeGame.gameStatus = GameStatus.Draw
                }
            }
        }
        return ticTacToeGame
    }
}