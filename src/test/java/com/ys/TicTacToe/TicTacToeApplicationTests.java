package com.ys.TicTacToe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.ys.TicTacToe.service.TicTacToeService;

@SpringBootTest
class TicTacToeApplicationTests {
	
	@Autowired
	private TicTacToeService ticTacToeService;

	@Test
	void contextLoads() {
		Assert.notNull(ticTacToeService, "TicTacToeService autowiring failed");
	}

}
