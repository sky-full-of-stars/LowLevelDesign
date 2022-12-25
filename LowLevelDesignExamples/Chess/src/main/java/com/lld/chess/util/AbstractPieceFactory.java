package com.lld.chess.util;

import com.lld.chess.model.Piece;

import java.util.List;

public interface AbstractPieceFactory {
    List<Piece> getWhitePieces();
    List<Piece> getBlackPieces();
}
