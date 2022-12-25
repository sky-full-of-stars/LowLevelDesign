package com.lld.chess.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ChessBoard {
    private List<Piece> pieces;
    private Map<Position, Piece> positionPieceMap;

    public ChessBoard(List<Piece> pieces, Map<Position, Piece> positionPieceMap) {
        this.pieces = pieces;
        this.positionPieceMap = positionPieceMap;
    }

}
