package com.ys.TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ys.TicTacToe.model.GameBoard;
import com.ys.TicTacToe.model.PlayerEnum;
import com.ys.TicTacToe.service.TicTacToeService;

@SpringBootApplication
public class TicTacToeApplication {

	private GameBoard board;
	private BufferedReader reader;

	@Autowired
	private TicTacToeService ticTacToeService;

	public static void main(String[] args) {
		SpringApplication.run(TicTacToeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			reader = new BufferedReader(new InputStreamReader(System.in));
			board = new GameBoard();

			System.out.println("Welcome to Tic-Tac-Toe.");
			System.out.println("This game is played by 2 players. The first one to have 3 in a row wins the game.");
			System.out.println("Player X starts. You can just type in a number between 1 and 9 to place your X.");
			System.out.println("After player X, it's player's O turn to choose a number between 1 and 9.");
			
			startGame();

		};
	}

	private void startGame() {
		printBoard(board);
		playTurn();
	}

	private void playTurn() {
		if (ticTacToeService.isThereAWinner(board) == null && !ticTacToeService.isBoardFull(board)) {
			
			int place = -1;
			try {
				System.out.println(askForNextInput());
				String placeInput = reader.readLine();
				
				place = Integer.parseInt(placeInput);
			} catch (NumberFormatException nfe) {
				System.out.println("It has to be a number between 1 and 9");
				playTurn();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (place != -1) {
				try {
					ticTacToeService.place(board, place);
				} catch (IllegalArgumentException iae) {
					System.out.println(iae.getMessage());	
				} catch (IllegalStateException ise) {
					System.out.println(ise.getMessage());
				}
				startGame();
			}

		} else {
			checkForWinner();
			askReplay();
		}

	}

	private void askReplay() {
		System.out.println("You wanna play another game? Answer with y if you want a rematch");
		
		String rematch = null;
		try {
			rematch = reader.readLine();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if("y".equals(rematch.toLowerCase())) {
			board = new GameBoard();
			startGame();
		}
		
		
	}

	private void checkForWinner() {
		if(ticTacToeService.isBoardFull(board)) {
			System.out.println("No one has won. It's a tie.");
		} else {
			String winner = ticTacToeService.isThereAWinner(board) == PlayerEnum.PLAYERX? "X" : "O";
			System.out.println("Congratulations, player " + winner + " won.");
		}
		
		
	}

	private String askForNextInput() {
		return "Player " + ticTacToeService.decidePlayer(board) + ". Please choose a number between 1 and 9: ";
	}

	private void printBoard(GameBoard board) {
		System.out.println();
		System.out.println(board.toString());
		System.out.println();
	}
}
