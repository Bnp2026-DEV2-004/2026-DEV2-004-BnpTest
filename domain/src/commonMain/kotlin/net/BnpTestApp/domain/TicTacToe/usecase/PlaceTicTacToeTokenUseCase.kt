package net.BnpTestApp.domain.TicTacToe.usecase

import net.BnpTestApp.domain.TicTacToe.entities.CellAlreadyOccupiedError
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeBoard
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeGame
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeToken

class PlaceTicTacToeTokenUseCase {

    suspend operator fun invoke(
        rowIndex: Int,
        columnIndex: Int,
        game: TicTacToeGame,
    ) {
        getAppropriateTicTacToeToken(game.lastPlacedTicTacToeToken).let { ticTacToeTokenToPlace ->
            fillCellWithContent(
                ticTacToeBoard = game.ticTacToeBoard,
                rowIndex = rowIndex,
                columnIndex = columnIndex,
                ticTacToeTokenToPlace = ticTacToeTokenToPlace
            )
            game.lastPlacedTicTacToeToken = ticTacToeTokenToPlace
        }
    }

    private fun getAppropriateTicTacToeToken(lastPlayedCell: TicTacToeToken): TicTacToeToken {
        return when (lastPlayedCell) {
            TicTacToeToken.EMPTY,
            TicTacToeToken.CIRCLE -> TicTacToeToken.CROSS
            TicTacToeToken.CROSS -> TicTacToeToken.CIRCLE
        }
    }

    private fun fillCellWithContent(
        ticTacToeBoard: TicTacToeBoard,
        rowIndex: Int,
        columnIndex: Int,
        ticTacToeTokenToPlace: TicTacToeToken
    ) {
        ticTacToeBoard.cells[rowIndex][columnIndex].let { cellToFill ->
            if (cellToFill.ticTacToeToken == TicTacToeToken.EMPTY) {
                cellToFill.ticTacToeToken = ticTacToeTokenToPlace
            } else {
                throw CellAlreadyOccupiedError()
            }
        }
    }
}