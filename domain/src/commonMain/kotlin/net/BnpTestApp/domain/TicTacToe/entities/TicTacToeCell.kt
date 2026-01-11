package net.BnpTestApp.domain.TicTacToe.entities

data class TicTacToeCell(
    var ticTacToeToken: TicTacToeToken
)

enum class TicTacToeToken{
    EMPTY,
    CROSS,
    CIRCLE
}
