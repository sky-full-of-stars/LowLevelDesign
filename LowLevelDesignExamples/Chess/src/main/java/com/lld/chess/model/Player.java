package com.lld.chess.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    int id;
    String name;
    String pieceColor;
}
