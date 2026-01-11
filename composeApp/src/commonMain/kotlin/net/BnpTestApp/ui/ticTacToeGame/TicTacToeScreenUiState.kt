package net.BnpTestApp.ui.ticTacToeGame


sealed class TicTacToeScreenUiState {

    data object Loading : TicTacToeScreenUiState()
    data class DisplayingGame(
        val boardCells: List<List<BoardCellState>>,
    ) : TicTacToeScreenUiState()

    data class DisplayingWinner(
        val winner: Winner,
    ) : TicTacToeScreenUiState()

    data object DisplayingDraw : TicTacToeScreenUiState()
}

enum class Winner {
    CROSS,
    CIRCLE
}

enum class BoardCellState {
    EMPTY,
    CROSS,
    CIRCLE
}

sealed class TicTacToeScreenEvent {
    data class OnCellClicked(
        val rowIndex: Int,
        val columnIndex: Int
    ) : TicTacToeScreenEvent()

    data object OnRestartGameClicked : TicTacToeScreenEvent()
}