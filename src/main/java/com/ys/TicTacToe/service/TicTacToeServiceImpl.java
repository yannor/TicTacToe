package com.ys.TicTacToe.service;

import java.util.Arrays;

import com.ys.TicTacToe.model.GameBoard;
import com.ys.TicTacToe.model.PlayerEnum;

public class TicTacToeServiceImpl implements TicTacToeService {

	@Override
	public GameBoard place(GameBoard board, int place) {
		validatePlacement(board, place);
		board.place(decidePlayer(board), place - 1);
		return board;
	}


	@Override
	public PlayerEnum isThereAWinner(GameBoard board) {
		int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
		
		 for (int[] position : winningPositions) {
             if (board.getBoardPlacements()[position[0]] != null
                     && board.getBoardPlacements()[position[0]] == board.getBoardPlacements()[position[1]]
                     && board.getBoardPlacements()[position[0]] == board.getBoardPlacements()[position[2]]) {
            	 
            	 // We have a winner
            	 return board.getBoardPlacements()[position[0]] == 1?  PlayerEnum.PLAYERX : PlayerEnum.PLAYERO;
                
             }
		 }
		
		 // We have no winner
		return null;
	}

	private int decidePlayer(GameBoard board) {
		return Arrays.stream(board.getBoardPlacements()).filter(i -> i != null).count() % 2 == 0 ? 1 : 2;
	}
	
	private void validatePlacement(GameBoard board, int place) {
		if (place<1 || place >9) {
			throw new IllegalArgumentException("This is not a valid place. The place has to be between 1 and 9.");
		}

		if (board.getBoardPlacements()[place-1] != null) {
			throw new IllegalArgumentException("This is not a valid place. Someone already placed here.");
		}
		
		if(isThereAWinner(board)!= null) {
			throw new IllegalStateException("We already have a winner. Nothing more can be placed.");
		}
	}
}
