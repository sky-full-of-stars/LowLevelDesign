package com.lld.chess.model;

import lombok.Data;

@Data
public abstract class Piece {
    Position position;
    String name;
    //checks if a move from position x to y is valid for a piece or not.
    public abstract boolean isValidMove(Position x, Position y);

    //checks if a piece can move from x to y without interfering with any other pieces in between.
    public abstract boolean isNoInteruptionPresent(Position x, Position y);
}
