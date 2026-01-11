package net.BnpTestApp.domain.TicTacToe.usecase

import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeBoard
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeCell
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeToken
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CheckForWinnerUseCaseTest {

    private lateinit var cut : CheckForWinnerUseCase

    @Before
    fun setup() {
        cut = CheckForWinnerUseCase()
    }

    @Test
    fun testFirstRowFilledWithCrosses() {
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

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assertEquals(TicTacToeToken.CROSS, winner)
    }

    @Test
    fun testMiddleRowFilledWithCrosses() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                )
            )
        )

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assert(winner == TicTacToeToken.CROSS)
    }

    @Test
    fun testLastRowFilledWithCrosses() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS)
                )
            )
        )

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assertEquals(TicTacToeToken.CROSS, winner)
    }

    @Test
    fun testFirstColumnFilledWithCrosses() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                )
            )
        )

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assertEquals(TicTacToeToken.CROSS, winner)
    }

    @Test
    fun testSecondColumnFilledWithCrosses() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                )
            )
        )

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assertEquals(TicTacToeToken.CROSS, winner)
    }

    @Test
    fun testThirdColumnFilledWithCrosses() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS)
                )
            )
        )

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assertEquals(TicTacToeToken.CROSS, winner)
    }

    @Test
    fun testFirstRowFilledWithCircle() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS)
                )
            )
        )

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assertEquals(TicTacToeToken.CIRCLE, winner)
    }

    @Test
    fun testSecondRowFilledWithCircle() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                )
            )
        )

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assertEquals(TicTacToeToken.CIRCLE, winner)
    }

    @Test
    fun testLastRowFilledWithCircle() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE)
                )
            )
        )

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assertEquals(TicTacToeToken.CIRCLE, winner)
    }

    @Test
    fun testFirstColumnFilledWithCircle() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                )
            )
        )

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assertEquals(TicTacToeToken.CIRCLE, winner)
    }

    @Test
    fun testSecondColumnFilledWithCircle() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                )
            )
        )

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assertEquals(TicTacToeToken.CIRCLE, winner)
    }

    @Test
    fun testThirdColumnFilledWithCircle() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE)
                )
            )
        )

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assertEquals(TicTacToeToken.CIRCLE, winner)
    }

    @Test
    fun testDiagonal1FilledWithCircle() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE)
                )
            )
        )

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assertEquals(TicTacToeToken.CIRCLE, winner)
    }

    @Test
    fun testDiagonal2FilledWithCircle() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.EMPTY)
                )
            )
        )

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assertEquals(TicTacToeToken.CIRCLE, winner)
    }

    @Test
    fun testNoWinner() {
        // Given
        val ticTacToeBoard = TicTacToeBoard(
            cells = listOf(
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE)
                ),
                listOf(
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CIRCLE),
                    TicTacToeCell(ticTacToeToken = TicTacToeToken.CROSS)
                )
            )
        )

        // When
        val winner = cut.invoke(ticTacToeBoard)

        // Then
        assertNull(winner)
     }
}