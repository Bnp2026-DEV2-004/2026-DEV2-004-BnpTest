package net.BnpTestApp.ui.ticTacToeGame

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import net.BnpTestApp.designSystem.tokens.bnpTestAppColors
import net.BnpTestApp.designSystem.tokens.bnpTestAppSpacing
import net.BnpTestApp.designSystem.tokens.bnpTestAppTypography
import net.BnpTestApp.ui.ticTacToeGame.TicTacToeScreenEvent.OnCellClicked
import net.BnpTestApp.ui.ticTacToeGame.TicTacToeScreenEvent.OnRestartGameClicked


@Composable
fun TicTacToeGameScreen(
    viewModel: TicTacToeScreenViewModel = viewModel(factory = ticTacToeScreenViewModelFactory)
) {
    val uiState = viewModel.uiState.collectAsState(TicTacToeScreenUiState.Loading)
    when (val state = uiState.value) {
        is TicTacToeScreenUiState.DisplayingGame -> {
            Column(
                modifier = Modifier.fillMaxWidth().background(bnpTestAppColors.background)
            ) {
                TicTacToeGrid(
                    boardCells = state.boardCells,
                    onCellClicked = { rowIndex, columnIndex ->
                        viewModel.handleEvent(
                            OnCellClicked(
                                rowIndex = rowIndex,
                                columnIndex = columnIndex
                            )
                        )
                    }
                )
            }
        }
        TicTacToeScreenUiState.Loading -> {
            Text(
                text = "Loading...",
                style = bnpTestAppTypography.h2,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bnpTestAppSpacing.listVerticalSpacing)
                    .background(bnpTestAppColors.surface)
                    .padding(bnpTestAppSpacing.listVerticalSpacing)
            )
        }

        TicTacToeScreenUiState.DisplayingDraw -> {
            ItSADrawScreen { viewModel.handleEvent(OnRestartGameClicked) }
        }
        is TicTacToeScreenUiState.DisplayingWinner -> {
            TheWinnerIsScreen(
                winner = state.winner,
                onRestartGameClicked = { viewModel.handleEvent(OnRestartGameClicked) }
            )
        }
    }
}


@Composable
fun ItSADrawScreen(
    onRestartGameClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bnpTestAppSpacing.listVerticalSpacing)
            .background(bnpTestAppColors.surface),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "It's a Draw!",
            style = bnpTestAppTypography.h2,
            modifier = Modifier.padding(bottom = bnpTestAppSpacing.listVerticalSpacing)
        )
        Button(onClick = onRestartGameClicked) {
            Text(text = "Restart Game")
        }
    }
}

@Composable
fun TheWinnerIsScreen(
    winner: Winner,
    onRestartGameClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bnpTestAppSpacing.listVerticalSpacing)
            .background(bnpTestAppColors.surface),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val winnerText = when(winner) {
            Winner.CROSS -> "X"
            Winner.CIRCLE -> "O"
        }
        Text(winnerText, style = bnpTestAppTypography.h1.copy(
            when(winner) {
                Winner.CROSS -> bnpTestAppColors.secondary
                Winner.CIRCLE -> bnpTestAppColors.primary
            }
        ))
        Text(
            text = "is the Winner!",
            style = bnpTestAppTypography.h2,
            modifier = Modifier.padding(bottom = bnpTestAppSpacing.listVerticalSpacing)
        )
        Button(onClick = onRestartGameClicked) {
            Text(text = "Restart Game")
        }
    }
}

@Composable
fun TicTacToeGrid(
    boardCells: List<List<BoardCellState>>,
    onCellClicked: (rowIndex: Int, columnIndex: Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bnpTestAppSpacing.listVerticalSpacing)
            .background(bnpTestAppColors.surface)
    ) {
        boardCells.forEachIndexed { rowIndex, row ->
            Row {
                row.forEachIndexed { columnIndex, cell ->
                    TicTacToeCell(
                        cellState = cell,
                        weight = 1f,
                        onClick = {
                            onCellClicked(rowIndex, columnIndex)
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun RowScope.TicTacToeCell(
    cellState: BoardCellState,
    weight: Float,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .border(2.dp, bnpTestAppColors.tertiary)
            .weight(weight)
            .aspectRatio(1f)
            .clickable{ onClick() }
    ) {
        when (cellState) {
            BoardCellState.CROSS -> {
                Text(
                    text = "X",
                    style = bnpTestAppTypography.h1.copy(color = bnpTestAppColors.secondary),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            BoardCellState.CIRCLE -> {
                Text(
                    text = "O",
                    style = bnpTestAppTypography.h1.copy(color = bnpTestAppColors.primary),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            BoardCellState.EMPTY -> {}
        }
    }
}
