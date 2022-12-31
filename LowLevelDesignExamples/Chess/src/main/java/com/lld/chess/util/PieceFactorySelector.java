package com.lld.chess.util;

import com.lld.chess.enums.BoardType;

public class PieceFactorySelector {
    StandardPiecesFactory standardPiecesFactory;

    public AbstractPieceFactory getPieceFactory(BoardType type) {
        if (BoardType.STANDARD.equals(type)) {
            return standardPiecesFactory;
        }
        return standardPiecesFactory;
    }

}
