package com.lld.chess;

import com.lld.chess.enums.Color;
import com.lld.chess.model.Player;
import com.lld.chess.service.ChessGameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ChessApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChessApplication.class, args);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter player 1 name, Player 1 will take white");
        String player1Name = scanner.nextLine();
        Player player1 = new Player(1, player1Name, Color.WHITE.name());

        System.out.println("Enter player 2 name, Player 2 will take black");
        String player2Name = scanner.nextLine();
        Player player2 = new Player(2, player2Name, Color.BLACK.name());

        ChessGameService gameService = new ChessGameService(player1, player2);
        gameService.startGame();
    }

}
