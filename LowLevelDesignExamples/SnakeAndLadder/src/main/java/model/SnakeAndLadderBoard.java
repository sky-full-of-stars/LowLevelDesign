package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SnakeAndLadderBoard {
    private List<Snake> snakes;
    private List<Ladder> ladders;
}
