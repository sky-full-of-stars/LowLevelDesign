package com.lld.chess.model;

import lombok.Data;

@Data
public class Knight extends Piece {
    @Override
    public boolean isValidMove(Position x, Position y) {
        return false;
    }

    @Override
    public boolean isNoInteruptionPresent(Position x, Position y) {
        return false;
    }
}
