package net.BnpTestApp.domain.TicTacToe.usecase

class PlaceTicTacToeTokenAndCheckCurrentGameStatusUseCase(
    private val placeTicTacToeTokenUseCase: PlaceTicTacToeTokenUseCase,
    private val checkAndUpdateGameStatusUseCase: CheckAndUpdateGameStatusUseCase,
    private val getCurrentTicTacToeGameUseCase: GetCurrentTicTacToeGameUseCase,
    private val publishUpdatedGameUseCase: PublishUpdatedGameUseCase,
) {

    suspend operator fun invoke(
        rowIndex: Int,
        columnIndex: Int,
    ) {
        getCurrentTicTacToeGameUseCase().let { game ->
            placeTicTacToeTokenUseCase(rowIndex, columnIndex, game)
            checkAndUpdateGameStatusUseCase(game)
            publishUpdatedGameUseCase(game)
        }
    }
}