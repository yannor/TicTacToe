package com.ys.TicTacToe.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

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
	public void placeOneX() {
		ticTacToeService.place(gameBoard, 1);

		String[] expectedPlacements = { "X", null, null, null, null, null, null, null, null };
		assertTrue(Arrays.equals(expectedPlacements, gameBoard.getBoardPlacements()));
	}

	@Test
	public void placeOneO() {
		String[] beginSituation = { "X", null, null, null, null, null, null, null, null };
		gameBoard.setBoardPlacements(beginSituation);

		ticTacToeService.place(gameBoard, 5);

		String[] expectedPlacements = { "X", null, null, null, "O", null, null, null, null };

		assertTrue(Arrays.equals(expectedPlacements, gameBoard.getBoardPlacements()));
	}

	@Test
	public void placeInvalidNotExisting() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			ticTacToeService.place(gameBoard, 12);
		});

		String expectedMessage = "This is not a valid place. The place has to be between 1 and 9.";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void placeInvalidNotAlreadyPlaced() {
		String[] beginSituation = { "X", null, null, null, null, null, null, null, null };
		gameBoard.setBoardPlacements(beginSituation);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			ticTacToeService.place(gameBoard, 1);
		});

		String expectedMessage = "This is not a valid place. Someone already placed here.";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void placeAfterWinner() {
		String[] placements = { "X", "X", "X", "O", null, null, "O", null, null };
		gameBoard.setBoardPlacements(placements);

		PlayerEnum winner = ticTacToeService.isThereAWinner(gameBoard);
		assertEquals(PlayerEnum.PLAYERX, winner);

		Exception exception = assertThrows(IllegalStateException.class, () -> {
			ticTacToeService.place(gameBoard, 5);
		});

		String expectedMessage = "We already have a winner. Nothing more can be placed.";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void weHaveNoWinner() {
		String[] placements = { "X", "X", "O", "O", "X", "O", null, null, null };
		gameBoard.setBoardPlacements(placements);

		PlayerEnum winner = ticTacToeService.isThereAWinner(gameBoard);
		assertNull(winner);
	}

	@Test
	public void weHaveWinnerX() {
		String[] placements = { "X", "X", "X", "O", null, null, "O", null, null };
		gameBoard.setBoardPlacements(placements);

		PlayerEnum winner = ticTacToeService.isThereAWinner(gameBoard);
		assertEquals(PlayerEnum.PLAYERX, winner);
	}

	@Test
	public void weHaveWinnerO() {
		String[] placements = { "X", null, "X", "O", "O", "O", "X", null, null };
		gameBoard.setBoardPlacements(placements);

		PlayerEnum winner = ticTacToeService.isThereAWinner(gameBoard);
		assertEquals(PlayerEnum.PLAYERO, winner);
	}
	
	@Test
	public void isBoardFullTrue() {
		String[] placements = { "X", "X", "X", "O", "X", "O", "X", "X", "X" };
		gameBoard.setBoardPlacements(placements);
		assertTrue(ticTacToeService.isBoardFull(gameBoard));
	}
	
	@Test
	public void isBoardFullFalse() {
		String[] placements = { "X", null, "X", "O", null, "O", "X", null, null };
		gameBoard.setBoardPlacements(placements);
		assertFalse(ticTacToeService.isBoardFull(gameBoard));
	}

}
