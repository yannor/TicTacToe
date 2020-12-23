package com.ys.TicTacToe.model;

public class GameBoard {
	private Integer[] boardPlacements;

	public GameBoard() {
		super();
		this.boardPlacements = new Integer[9];
	}

	public GameBoard(Integer[] boardPlacements) {
		super();
		this.boardPlacements = boardPlacements;
	}

	public Integer[] getBoardPlacements() {
		return boardPlacements;
	}
	
	

	public void setBoardPlacements(Integer[] boardPlacements) {
		this.boardPlacements = boardPlacements;
	}
	
	public void place(int player, int place) {
		boardPlacements[place] = player;
	}

	public String printBoard() {

		return "";
	}

	

}
