package net.BnpTestApp.ui.ticTacToeGame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import net.BnpTestApp.KoinResolver
import net.BnpTestApp.domain.TicTacToe.entities.CellAlreadyOccupiedError
import net.BnpTestApp.domain.TicTacToe.entities.GameStatus
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeBoard
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeGame
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeToken
import net.BnpTestApp.domain.TicTacToe.usecase.ObserveCurrentGameUseCase
import net.BnpTestApp.domain.TicTacToe.usecase.PlaceTicTacToeTokenAndUpdateCurrentGameStatusUseCase
import net.BnpTestApp.domain.TicTacToe.usecase.ResetCurrentGameUseCase
import org.koin.core.component.KoinComponent

class TicTacToeScreenViewModel(
    private val observeCurrentGameUseCase: ObserveCurrentGameUseCase,
    private val placeTicTacToeTokenAndUpdateCurrentGameStatusUseCase: PlaceTicTacToeTokenAndUpdateCurrentGameStatusUseCase,
    private val resetGameUseCase: ResetCurrentGameUseCase
): ViewModel(), KoinComponent {

    private val _uiState = MutableStateFlow<TicTacToeScreenUiState>(TicTacToeScreenUiState.Loading)
    val uiState: Flow<TicTacToeScreenUiState> = _uiState

    init {
        viewModelScope.launch {
            observeCurrentGameUseCase().collect { ticTacToeGame ->
                _uiState.value = ticTacToeGame.toUiState()
            }
        }
    }

    fun handleEvent(event: TicTacToeScreenEvent) {
        viewModelScope.launch {
            try {
                when (event) {
                    is TicTacToeScreenEvent.OnCellClicked -> onCellClicked(event.rowIndex, event.columnIndex)
                    TicTacToeScreenEvent.OnRestartGameClicked -> onRestartGameClicked()
                }
            } catch (e: CellAlreadyOccupiedError) {
                // display cell already occupied error
                e.printStackTrace()
            } catch (e: Exception) {
                // logs error to monitoring service
                e.printStackTrace()
            }
        }
    }

    private suspend fun onCellClicked(rowIndex: Int, columnIndex: Int) {
        placeTicTacToeTokenAndUpdateCurrentGameStatusUseCase(
            rowIndex = rowIndex,
            columnIndex = columnIndex
        )
    }

    private suspend fun onRestartGameClicked() {
        resetGameUseCase()
    }
}


val ticTacToeScreenViewModelFactory = viewModelFactory {
    initializer {
        KoinResolver.resolve<TicTacToeScreenViewModel>()
    }
}

fun TicTacToeBoard.toUi(): List<List<BoardCellState>> {
    return this.cells.map { row ->
        row.map { cell ->
            when (cell.ticTacToeToken) {
                TicTacToeToken.EMPTY -> BoardCellState.EMPTY
                TicTacToeToken.CROSS -> BoardCellState.CROSS
                TicTacToeToken.CIRCLE -> BoardCellState.CIRCLE
            }
        }
    }
}

fun TicTacToeGame.toUiState(): TicTacToeScreenUiState {
    return when (val satus = gameStatus) {
        is GameStatus.CompletedWithWinner -> {
            TicTacToeScreenUiState.DisplayingWinner(
                satus.toUi()
            )
        }

        GameStatus.Draw -> {
            TicTacToeScreenUiState.DisplayingDraw
        }

        GameStatus.InProgress -> {
            TicTacToeScreenUiState.DisplayingGame(
                boardCells = ticTacToeBoard.toUi()
            )
        }
    }
}

fun GameStatus.CompletedWithWinner.toUi(): Winner {
    return when (winner) {
        TicTacToeToken.CROSS -> Winner.CROSS
        TicTacToeToken.CIRCLE -> Winner.CIRCLE
        else -> throw IllegalStateException("Winner token cannot be EMPTY")
    }
}