package net.BnpTestApp.domain.TicTacToe.usecase

import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeBoard
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeToken

class CheckForWinnerUseCase {

     operator fun invoke(ticTacToeBoard: TicTacToeBoard): TicTacToeToken? {
        var winner: TicTacToeToken? = null
        ticTacToeBoard.cells.let { allCells ->

            // Check rows
            for(columnIndex in 0..allCells.size-1) {
                var nbCross = 0
                var nbCircle = 0
                for(rowIndex in 0..allCells.size-1) {
                    if (allCells[rowIndex][columnIndex].ticTacToeToken == TicTacToeToken.CROSS) {
                        nbCross++
                    }
                    if (allCells[rowIndex][columnIndex].ticTacToeToken == TicTacToeToken.CIRCLE) {
                        nbCircle++
                    }
                }
                if (nbCross == allCells.size) {
                    winner = TicTacToeToken.CROSS
                }
                if (nbCircle == allCells.size) {
                    winner = TicTacToeToken.CIRCLE
                }
            }

            // Chedk Columns
            for(rowIndex in 0..allCells.size-1) {
                var nbCross = 0
                var nbCircle = 0
                for (columnIndex in 0..allCells.size-1) {
                    if (allCells[rowIndex][columnIndex].ticTacToeToken == TicTacToeToken.CROSS) {
                        nbCross++
                    }
                    if (allCells[rowIndex][columnIndex].ticTacToeToken == TicTacToeToken.CIRCLE) {
                        nbCircle++
                    }
                }
                if (nbCross == allCells.size) {
                    winner = TicTacToeToken.CROSS
                }
                if (nbCircle == allCells.size) {
                    winner = TicTacToeToken.CIRCLE
                }
            }

            // Check first diagonal
            var nbCross = 0
            var nbCircle = 0
            for(columnIndex in 0..allCells.size-1) {
                if (allCells[columnIndex][columnIndex].ticTacToeToken == TicTacToeToken.CROSS) {
                    nbCross++
                }
                if (allCells[columnIndex][columnIndex].ticTacToeToken == TicTacToeToken.CIRCLE) {
                    nbCircle++
                }
            }
            if (nbCross == allCells.size) {
                winner = TicTacToeToken.CROSS
            }
            if (nbCircle == allCells.size) {
                winner = TicTacToeToken.CIRCLE
            }
            // Check second diagonal
            nbCross = 0
            nbCircle = 0
            for (columnIndex in 0..allCells.size-1) {
                val x = allCells.size-1 - columnIndex
                if (allCells[columnIndex][x].ticTacToeToken == TicTacToeToken.CROSS) {
                    nbCross++
                }
                if (allCells[columnIndex][x].ticTacToeToken == TicTacToeToken.CIRCLE) {
                    nbCircle++
                }
            }
            if (nbCross == allCells.size) {
                winner = TicTacToeToken.CROSS
            }
            if (nbCircle == allCells.size) {
                winner = TicTacToeToken.CIRCLE
            }
        }

        return winner
    }

}