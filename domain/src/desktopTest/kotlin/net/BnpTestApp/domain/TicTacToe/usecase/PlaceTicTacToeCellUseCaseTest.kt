package net.BnpTestApp.domain.TicTacToe.usecase

import kotlinx.coroutines.runBlocking
import net.BnpTestApp.domain.TicTacToe.entities.CellAlreadyOccupiedError
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeGame
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeToken
import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

class PlaceTicTacToeCellUseCaseTest {

    private lateinit var cut:  PlaceTicTacToeTokenUseCase
    private val ticTacToeGame = TicTacToeGame()

    @Before
    fun setup() {
        cut = PlaceTicTacToeTokenUseCase()
    }

    @Test
    fun givenFirstDrawRow_whenInvoke_thenCellContentIsChangedToACross(): Unit = runBlocking {
            // when
            cut.invoke(
                rowIndex = 1,
                columnIndex = 2,
                ticTacToeGame
            )

            // then
            assertTrue { ticTacToeGame.ticTacToeBoard.cells[1][2].ticTacToeToken == TicTacToeToken.CROSS }
    }

    @Test
    fun givenSecondDrawRow_whenInvoke_thenCellContentIsChangedToACircle(): Unit = runBlocking {
            // given
            cut.invoke(rowIndex = 1, columnIndex = 2, ticTacToeGame)

            // when
            cut.invoke(rowIndex = 0, columnIndex = 0, ticTacToeGame)

            // then
            assertTrue { ticTacToeGame.ticTacToeBoard.cells[0][0].ticTacToeToken == TicTacToeToken.CIRCLE }
    }

    @Test
    fun givenThirdDrawRow_whenInvoke_thenCellContentIsChangedToACross(): Unit = runBlocking {
            // given
            cut.invoke(rowIndex = 1, columnIndex = 2, ticTacToeGame)
            cut.invoke(rowIndex = 0, columnIndex = 0, ticTacToeGame)

            // when
            cut.invoke(rowIndex = 2, columnIndex = 1, ticTacToeGame)

            // then
            assertTrue { ticTacToeGame.ticTacToeBoard.cells[2][1].ticTacToeToken == TicTacToeToken.CROSS }
    }

    @Test
    fun givenOccupiedCell_whenInvoke_thenThrowCellAlreadyOccupiedError(): Unit = runBlocking {
            // given
            cut.invoke(rowIndex = 1, columnIndex = 2, ticTacToeGame)

            // when
            var exception : Exception? = null
            try {
                cut.invoke(rowIndex = 1, columnIndex = 2, ticTacToeGame)
            } catch (e: Exception) {
                exception = e
            }

            // then
            assertTrue { exception is CellAlreadyOccupiedError }
    }
}