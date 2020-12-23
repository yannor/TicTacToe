package com.ys.TicTacToe.model;

public class GameBoard {
	private String[] boardPlacements;

	public GameBoard() {
		super();
		this.boardPlacements = new String[9];
	}

	public GameBoard(String[] boardPlacements) {
		super();
		this.boardPlacements = boardPlacements;
	}

	public String[] getBoardPlacements() {
		return boardPlacements;
	}
	
	

	public void setBoardPlacements(String[] boardPlacements) {
		this.boardPlacements = boardPlacements;
	}
	
	public void place(String player, int place) {
		boardPlacements[place] = player;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(addLine(0, 1, 2));
		builder.append(addSeperator());
		builder.append(addLine(3, 4, 5));
		builder.append(addSeperator());
		builder.append(addLine(6, 7, 8));
		
		return builder.toString();
	}

	private Object addSeperator() {
		StringBuilder builder = new StringBuilder();
		builder.append(System.getProperty("line.separator"));
		builder.append("- - -");
		builder.append(System.getProperty("line.separator"));
		return builder.toString();	
	}

	private String addLine(int pos1, int pos2, int pos3) {
		StringBuilder builder = new StringBuilder();
		builder.append(boardPlacements[pos1]== null? " " : boardPlacements[pos1]);
		builder.append("|");
		builder.append(boardPlacements[pos2]== null? " " : boardPlacements[pos2]);
		builder.append("|");
		builder.append(boardPlacements[pos3]== null? " " : boardPlacements[pos3]);
		return builder.toString();
	}

}
