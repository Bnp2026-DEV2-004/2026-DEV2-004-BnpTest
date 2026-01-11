package net.BnpTestApp.domain.TicTacToe.usecase

import io.mockk.every
import io.mockk.mockk
import net.BnpTestApp.domain.TicTacToe.entities.GameStatus
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeGame
import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeToken
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertNull

class CheckAndUpdateGameStatusUseCaseTest {

    private lateinit var cut: CheckAndUpdateGameStatusUseCase
    private val mockCheckForWinnerUseCase = mockk<CheckForWinnerUseCase>()
    private val mockCheckIfBoardIsFullUseCase = mockk<CheckIfBoardIsFullUseCase>()

    @Before
    fun setup() {
        cut = CheckAndUpdateGameStatusUseCase(
            mockCheckForWinnerUseCase,
            mockCheckIfBoardIsFullUseCase
        )
    }

    @Test
    fun givenBoardIsNotFullAndNoWinner_whenInvoke_thenGameStatusIsInProgress() {
        // Given
        every { mockCheckIfBoardIsFullUseCase.invoke(any()) }.returns(false)
        every { mockCheckForWinnerUseCase.invoke(any()) }.returns(null)
        val ticTacToeGame = TicTacToeGame()

        // When
        cut.invoke(ticTacToeGame)

        // Then
        assert(ticTacToeGame.gameStatus is GameStatus.InProgress)
    }

    @Test
    fun givenWinnerExists_whenInvoke_thenGameStatusIsCompletedWithWinner() {
        // Given
        every { mockCheckIfBoardIsFullUseCase.invoke(any()) }.returns(false)
        every { mockCheckForWinnerUseCase.invoke(any()) }.returns(TicTacToeToken.CIRCLE)
        val ticTacToeGame = TicTacToeGame()

        // When
        cut.invoke(ticTacToeGame)

        // Then
        assert(ticTacToeGame.gameStatus is GameStatus.CompletedWithWinner)
        assert((ticTacToeGame.gameStatus as GameStatus.CompletedWithWinner).winner == TicTacToeToken.CIRCLE)
    }

    @Test
    fun givenBoardIsFullWithNoWinner_whenInvoke_thenGameStatusIsCompletedWithNoWinner() {
        // Given
        every { mockCheckIfBoardIsFullUseCase.invoke(any()) }.returns(true)
        every { mockCheckForWinnerUseCase.invoke(any()) }.returns(null)
        val ticTacToeGame = TicTacToeGame()

        // When
        cut.invoke(ticTacToeGame)

        // Then
        assert(ticTacToeGame.gameStatus is GameStatus.Draw)
    }

    @Test
    fun givenBoardIsFullAndWinnerExists_whenInvoke_thenGameStatusIsCompletedWithWinner() {
        // Given
        every { mockCheckIfBoardIsFullUseCase.invoke(any()) }.returns(true)
        every { mockCheckForWinnerUseCase.invoke(any()) }.returns(TicTacToeToken.CROSS)
        val ticTacToeGame = TicTacToeGame()

        // When
        cut.invoke(ticTacToeGame)

        // Then
        assert(ticTacToeGame.gameStatus is GameStatus.CompletedWithWinner)
        assert((ticTacToeGame.gameStatus as GameStatus.CompletedWithWinner).winner == TicTacToeToken.CROSS)
    }
}