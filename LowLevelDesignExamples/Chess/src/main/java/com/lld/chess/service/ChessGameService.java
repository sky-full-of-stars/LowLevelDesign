package com.lld.chess.service;

import com.lld.chess.enums.BoardType;
import com.lld.chess.model.ChessBoard;
import com.lld.chess.model.Piece;
import com.lld.chess.model.Player;
import com.lld.chess.model.Position;
import com.lld.chess.util.AbstractPieceFactory;
import com.lld.chess.util.PieceFactorySelector;

import java.util.*;

public class ChessGameService {

    private ChessBoard chessBoard;
    private Player player1;
    private Player player2;
    private Player winner = null;

    private List<Piece> getPiecesBasedOnBoardType(BoardType boardType) {
        AbstractPieceFactory pieceFactory = new PieceFactorySelector().getPieceFactory(boardType);
        List<Piece> pieces = new ArrayList<>();
        pieces.addAll(pieceFactory.getWhitePieces());
        pieces.addAll(pieceFactory.getBlackPieces());
        return pieces;
    }

    public ChessGameService(Player player1, Player player2) {
        List<Piece> piecesList = getPiecesBasedOnBoardType(BoardType.STANDARD);

        Map<Position, Piece> positionPieceMap = new HashMap<>();
        piecesList.forEach(v -> positionPieceMap.putIfAbsent(v.getPosition(),v));

        this.chessBoard = new ChessBoard(piecesList,positionPieceMap);
        this.player1 = player1;
        this.player2 = player2;
    }

    private boolean isDrawBoard() {
        return false;
    }

    private boolean isCurrentPlayerWin(Player currentPlayer) {
        return false;
    }

    private boolean isValidMove(Player currentPlayer, Position src, Position destination) {
        if(!isPieceInSrcBelongsToCurrentPlayer(currentPlayer, src)) {
            return false;
        }
        Piece currentPiece = chessBoard.getPositionPieceMap().get(src);
        return currentPiece.isValidMove(src, destination);
    }

    private boolean isPieceInSrcBelongsToCurrentPlayer(Player currentPlayer, Position src) {
        return false;
    }

    private void makeMove(Player currentPlayer, Position src, Position destination) {
    }

    private void updatePosition(Player currentPlayer, Position src, Position destination) {
    }

    public void startGame() {
        Queue<Player> playerQueue = new LinkedList<>();
        playerQueue.offer(player1);
        playerQueue.offer(player2);
        Scanner scanner = new Scanner(System.in);

        while(true) {
            Player currentPlayer = playerQueue.poll();

            while(true) {
                System.out.println("Enter source and destination of piece to move");
                int srcXCoordinate = scanner.nextInt();
                int srcYCoordinate = scanner.nextInt();
                int destXCoordinate = scanner.nextInt();
                int destYCoordinate = scanner.nextInt();
                Position src = new Position(srcXCoordinate, srcYCoordinate);
                Position destination = new Position(destXCoordinate, destYCoordinate);
                if(isValidMove(currentPlayer, src, destination)) {
                    makeMove(currentPlayer, src, destination);
                    updatePosition(currentPlayer, src, destination);
                    break;
                }
                else {
                    System.out.println("source and destination of piece to move is invalid");
                }
            }

            playerQueue.offer(currentPlayer);
            if(isCurrentPlayerWin(currentPlayer)) {
                this.winner = currentPlayer;
                System.out.println("Winner of the game is "+ winner);
                break;
            }
            if(isDrawBoard()) {
                System.out.println("Game draw!");
                break;
            }
        }
    }

}
