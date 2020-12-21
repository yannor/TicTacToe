/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ys.TicTacToe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ys.TicTacToe.service.TicTacToeService;
import com.ys.TicTacToe.service.TicTacToeServiceImpl;

/**
 *
 * @author Yannick
 */
@Configuration
@ComponentScan("com.ys.service")
public class Beans {

	@Bean
	public TicTacToeService autowiredTicTacToeService() {
		return new TicTacToeServiceImpl();
	}
}
