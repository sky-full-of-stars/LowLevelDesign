package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {

    private static final int BOARD_SIZE = 20;

    private int id;
    private String name;
    private int location;

    public void move(int steps) {
        if(this.location + steps < BOARD_SIZE)
            this.location = (this.location + steps);
        else
            this.location = BOARD_SIZE;
    }
}
