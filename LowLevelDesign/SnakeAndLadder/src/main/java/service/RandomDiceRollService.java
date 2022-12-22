package service;

import model.Dice;

import java.util.Random;

public class RandomDiceRollService implements DiceRollable{

    @Override
    public Dice rollDice() {
        final int randomNum = new Random().nextInt(7);
        return new Dice(randomNum);
    }
}
