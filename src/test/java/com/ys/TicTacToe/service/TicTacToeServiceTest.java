package com.ys.TicTacToe.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ys.TicTacToe.model.GameBoard;

@SpringBootTest
@RunWith(JUnit4.class)
class TicTacToeServiceTest {

	private GameBoard gameBoard;

	@Autowired
	private TicTacToeService ticTacToeService;

	@Before
	public void setUp() {
		gameBoard = new GameBoard();
	}

	@Test
	private void startGamePreSetup() {

	}

	@Test
	private void placeX() {

	}

	@Test
	private void placeO() {

	}

	@Test
	private void placeInvalid() {

	}

	@Test
	private void placeWinningX() {

	}

	@Test
	private void placeWinningO() {

	}

}
