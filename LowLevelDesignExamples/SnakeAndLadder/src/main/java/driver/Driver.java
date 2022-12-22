package driver;

import model.Ladder;
import model.Player;
import model.Snake;
import model.SnakeAndLadderBoard;
import service.SnakeAndLadderService;

import java.util.*;

public class Driver {
    public static void main(String[] args) {

        System.out.println("Enter number of ladders");
        List<Ladder> ladderList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numberOfLadders = scanner.nextInt();
        for(int i = 0; i< numberOfLadders; i++) {
            System.out.println("Enter starting and ending point of ladder "+ i);
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            ladderList.add(new Ladder(start, end));
        }

        System.out.println("Enter number of snakes");
        List<Snake> snakeList = new ArrayList<>();
        int numberOfSnakes = scanner.nextInt();
        for(int i = 0; i< numberOfSnakes; i++) {
            System.out.println("Enter starting and ending point of snakes "+ i);
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            snakeList.add(new Snake(start, end));
        }

        SnakeAndLadderBoard board = new SnakeAndLadderBoard(snakeList, ladderList);

        System.out.println("Enter num of players");
        Queue<Player> playerQueue = new LinkedList<>();
        int numOfPlayers = scanner.nextInt();
        for(int i=0; i<numOfPlayers; i++) {
            System.out.println("Enter name of player "+ i);
            String name = scanner.next();
            playerQueue.offer(new Player(i, name, 0));
        }

        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService(board,playerQueue);
        snakeAndLadderService.startGame();

    }
}
