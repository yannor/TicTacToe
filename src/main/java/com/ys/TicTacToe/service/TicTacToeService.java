/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ys.TicTacToe.service;

import org.springframework.stereotype.Component;

import com.ys.TicTacToe.model.GameBoard;

/**
 *
 * @author Yannick
 */

@Component
public class TicTacToeService {

	private GameBoard gameBoard;

	public TicTacToeService() {
		gameBoard = new GameBoard();
	}

	// We can start with a pre-setup board
	public GameBoard startGamePreSetup(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
		
		return gameBoard;
	}
	
	
	public GameBoard place(int place) {
		
		return gameBoard;
	}
	
}
