package net.BnpTestApp.domain.TicTacToe.usecase

import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeBoard
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeToken

class CheckIfBoardIsFullUseCase {

    operator fun invoke(ticTacToeBoard: TicTacToeBoard): Boolean {
        ticTacToeBoard.cells.forEach { row ->
            row.forEach { cell ->
                if (cell.ticTacToeToken == TicTacToeToken.EMPTY) {
                    return false
                }
            }
        }
        return true
    }
}