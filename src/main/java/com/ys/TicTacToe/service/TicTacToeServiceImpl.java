package com.ys.TicTacToe.service;

import com.ys.TicTacToe.model.GameBoard;
import com.ys.TicTacToe.model.PlayerEnum;

public class TicTacToeServiceImpl implements TicTacToeService {

	@Override
	public GameBoard place(GameBoard board, int place) {

		return board;
	}

	@Override
	public PlayerEnum isThereAWinner(GameBoard board) {
		PlayerEnum winner = null;
		return winner;
	}
}
