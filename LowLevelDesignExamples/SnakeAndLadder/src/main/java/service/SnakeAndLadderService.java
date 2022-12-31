package service;

import model.*;

import java.util.Optional;
import java.util.Queue;

public class SnakeAndLadderService {

    private static final int BOARD_SIZE = 20;
    private SnakeAndLadderBoard board;
    private Queue<Player> players;
    private final RandomDiceRollService diceRollService = new RandomDiceRollService();

    public SnakeAndLadderService(SnakeAndLadderBoard board, Queue<Player> players) {
        this.board = board;
        this.players = players;
    }

    private void updateInteruption(Player player) {
        updateIfSnakeInterferenceForPlayersMove(player);
        updateIfLadderInterferenceForPlayerMove(player);
    }

    public void updateIfSnakeInterferenceForPlayersMove(Player player) {
        int currentPosition = player.getLocation();
        final Optional<Snake> snake = board.getSnakes().stream().filter(v -> v.getEnd() == currentPosition).findFirst();
        snake.ifPresent(value -> player.setLocation(value.getStart()));
    }

    public void updateIfLadderInterferenceForPlayerMove(Player player) {
        int currentPosition = player.getLocation();
        final Optional<Ladder> ladder = board.getLadders().stream().filter(v -> v.getStart() == currentPosition).findFirst();
        ladder.ifPresent(value -> player.setLocation(value.getEnd()));
    }

    private boolean isPlayerWinner(Player currentPlayer) {
        return (currentPlayer.getLocation() == BOARD_SIZE);
    }

    private Dice getDiceRoll() {
        return diceRollService.rollDice();
    }

    public void startGame() {
        System.out.println("Starting the game");

        while (true) {
            if (null == players.peek()) {
                System.out.println("Game over");
                break;
            }

            Player currentPlayer = players.poll();
            System.out.println("Current player is " + currentPlayer.getName());

            Dice currentDice = getDiceRoll();
            System.out.println("Current dice roll number is " + currentDice.getNumber());
            currentPlayer.move(currentDice.getNumber());

            updateInteruption(currentPlayer);
            System.out.println("Updated" + currentPlayer.getName() + "position is " + currentPlayer.getLocation());

            if (isPlayerWinner(currentPlayer)) {
                System.out.println(currentPlayer + "won the game");
            }
            else {
                players.offer(currentPlayer);
            }
        }

    }
}
