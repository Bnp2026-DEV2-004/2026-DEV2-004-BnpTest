package net.BnpTestApp.domain.TicTacToe.entities

data class TicTacToeGame(
    val ticTacToeBoard: TicTacToeBoard = TicTacToeBoard(
        cells = List(3) {
            List(3) {
                TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
            }
        }
    ),
    var lastPlacedTicTacToeToken:TicTacToeToken = TicTacToeToken.EMPTY,
    var gameStatus: GameStatus = GameStatus.InProgress
)

sealed class GameStatus {
    object InProgress : GameStatus()
    data class CompletedWithWinner(val winner: TicTacToeToken) : GameStatus()

    object Draw : GameStatus()
}