package net.BnpTestApp.domain.TicTacToe.usecase

import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeBoard
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeCell
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeGame
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeToken
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CheckIfBoardIsFullUseCaseTest {

    private lateinit var cut : CheckIfBoardIsFullUseCase

    @Before
    fun setup() {
        cut = CheckIfBoardIsFullUseCase()
    }

    @Test
    fun givenEmptyBoard_whenInvoke_thenReturnFalse() {
        // Given
        val ticTacToeBoard = TicTacToeGame().ticTacToeBoard

        // When
        val boardFull = cut.invoke(ticTacToeBoard)

        // Then
        assertFalse(boardFull)
    }

    @Test
    fun givenPartiallyFilledBoard_whenInvoke_thenReturnFalse() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                )
            )
        )

        // when
        val boardFull = cut.invoke(ticTacToeBoard)

        // Then
        assertFalse(boardFull)
    }

    @Test
    fun givenBoardIsFull_whenInvoke_thenReturnTrue() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS)
                )
            )
        )

        // when
        val boardFull = cut.invoke(ticTacToeBoard)

        // Then
        assertTrue(boardFull)
    }
}