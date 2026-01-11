package net.BnpTestApp.domain.TicTacToe.repo

import net.BnpTestApp.domain.TicTacToe.entities.TicTacToeGame

interface GamesRepo {

    fun getCurrentTicTacToeGame(): TicTacToeGame

}