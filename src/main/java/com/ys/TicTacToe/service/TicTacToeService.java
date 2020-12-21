/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ys.TicTacToe.service;

import org.springframework.stereotype.Component;

import com.ys.TicTacToe.model.GameBoard;
import com.ys.TicTacToe.model.PlayerEnum;

/**
 *
 * @author Yannick
 */

@Component
public interface TicTacToeService {

	/*
	 * Place X or O on the given board on the given place. An X or O is placed
	 * depending on how filled the board is already.
	 * 
	 * @param board: The board that is being played
	 * 
	 * @param place: An integer between 0 and 9 where the new player has played.
	 * 
	 * @return the board filled in with the new placement
	 */
	public GameBoard place(GameBoard board, int place);

	/*
	 * Check if there is a winner on the board.
	 * 
	 * @param board: The board that is being played
	 * 
	 * @return PlayerEnum: A PlayerEnum telling who won, can be null if no one has
	 * won.
	 */
	public PlayerEnum isThereAWinner(GameBoard board);

}
