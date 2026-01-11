package net.BnpTestApp

import net.BnpTestApp.data.TicTacToe.repo.GamesRepoImpl
import net.BnpTestApp.data.TicTacToe.repo.dataSources.TicTacToeGameDataSource
import net.BnpTestApp.domain.TicTacToe.repo.GamesRepo
import net.BnpTestApp.domain.TicTacToe.usecase.CheckAndUpdateGameStatusUseCase
import net.BnpTestApp.domain.TicTacToe.usecase.CheckForWinnerUseCase
import net.BnpTestApp.domain.TicTacToe.usecase.CheckIfBoardIsFullUseCase
import net.BnpTestApp.domain.TicTacToe.usecase.GetCurrentTicTacToeGameUseCase
import net.BnpTestApp.domain.TicTacToe.usecase.ObserveCurrentGameUseCase
import net.BnpTestApp.domain.TicTacToe.usecase.PlaceTicTacToeTokenAndUpdateCurrentGameStatusUseCase
import net.BnpTestApp.domain.TicTacToe.usecase.PlaceTicTacToeTokenUseCase
import net.BnpTestApp.domain.TicTacToe.usecase.PublishUpdatedGameUseCase
import net.BnpTestApp.domain.TicTacToe.usecase.ResetCurrentGameUseCase
import net.BnpTestApp.ui.mainScreen.MainScreenViewModel
import net.BnpTestApp.ui.ticTacToeGame.TicTacToeScreenViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.dsl.module

val koinCommon = module {

    //////////////////////////////////////////////////////////////////
    // view models
    single {
        MainScreenViewModel()
    }
    single {
        TicTacToeScreenViewModel(get(), get(), get())
    }

    //////////////////////////////////////////////////////////////////
    // use cases
    factory {
        GetCurrentTicTacToeGameUseCase(get())
    }
    factory {
        PlaceTicTacToeTokenAndUpdateCurrentGameStatusUseCase(
            get(),
            get(),
            get(),
            get(),
        )
    }
    factory {
        PlaceTicTacToeTokenUseCase()
    }
    factory {
        CheckAndUpdateGameStatusUseCase(get(), get())
    }
    factory {
        PublishUpdatedGameUseCase(get())
    }
    factory {
        CheckForWinnerUseCase()
    }
    factory {
        CheckIfBoardIsFullUseCase()
    }
    factory {
        ObserveCurrentGameUseCase(get())
    }
    factory {
        ResetCurrentGameUseCase(get())
    }


    //////////////////////////////////////////////////////////////////
    // repo
    single<GamesRepo> {
        GamesRepoImpl(get())
    }


    //////////////////////////////////////////////////////////////////
    // data sources
    single {
        TicTacToeGameDataSource()
    }

    //////////////////////////////////////////////////////////////////
    // services


}

object KoinResolver : KoinComponent {
    inline fun <reified T> resolve(): T = get()
}