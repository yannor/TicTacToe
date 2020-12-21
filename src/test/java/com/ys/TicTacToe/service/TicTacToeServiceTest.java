package com.ys.TicTacToe.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ys.TicTacToe.model.GameBoard;
import com.ys.TicTacToe.model.PlayerEnum;

@SpringBootTest
public class TicTacToeServiceTest {

	private GameBoard gameBoard;

	@Autowired
	private TicTacToeService ticTacToeService;

	@BeforeEach
	public void setUp() {	
		gameBoard = new GameBoard();
	}

	@Test
	@Ignore
	public void placeOneX() {
		ticTacToeService.place(gameBoard, 0);

		Integer[] expectedPlacements = { 1, null, null, null, null, null, null, null, null };
		assertEquals(expectedPlacements, gameBoard.getBoardPlacements());
	}

	@Test
	@Ignore
	public void placeOneO() {
		Integer[] beginSituation = { 1, null, null, null, null, null, null, null, null };
		gameBoard.setBoardPlacements(beginSituation);

		ticTacToeService.place(gameBoard, 5);

		Integer[] expectedPlacements = { 1, null, null, null, null, 2, null, null, null };
		assertEquals(expectedPlacements, gameBoard.getBoardPlacements());
	}

	@Test
	@Ignore
	public void placeInvalid() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			ticTacToeService.place(gameBoard, 12);
		});

		String expectedMessage = "This is not a valid place. The place has to be between 1 and 9";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	@Ignore
	public void placeAfterWinner() {
		Integer[] placements = { 1, 1, 1, 2, null, null, 2, null, null };
		gameBoard.setBoardPlacements(placements);

		PlayerEnum winner = ticTacToeService.isThereAWinner(gameBoard);
		assertEquals(PlayerEnum.PLAYERX, winner);

		Exception exception = assertThrows(IllegalStateException.class, () -> {
			ticTacToeService.place(gameBoard, 4);
		});

		String expectedMessage = "We already have a winner. Nothing more can be placed.";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	@Ignore
	public void weHaveNoWinner() {
		Integer[] placements = { 1, 1, 2, 2, 1, 2, null, null, null };
		gameBoard.setBoardPlacements(placements);

		PlayerEnum winner = ticTacToeService.isThereAWinner(gameBoard);
		assertNull(winner);
	}

	@Test
	@Ignore
	public void weHaveWinnerX() {
		Integer[] placements = { 1, 1, 1, 2, null, null, 2, null, null };
		gameBoard.setBoardPlacements(placements);

		PlayerEnum winner = ticTacToeService.isThereAWinner(gameBoard);
		assertEquals(PlayerEnum.PLAYERX, winner);
	}

	@Test
	@Ignore
	public void weHaveWinnerO() {
		Integer[] placements = { 1, null, 1, 2, 2, 2, 1, null, null };
		gameBoard.setBoardPlacements(placements);

		PlayerEnum winner = ticTacToeService.isThereAWinner(gameBoard);
		assertEquals(PlayerEnum.PLAYERO, winner);
	}

}
