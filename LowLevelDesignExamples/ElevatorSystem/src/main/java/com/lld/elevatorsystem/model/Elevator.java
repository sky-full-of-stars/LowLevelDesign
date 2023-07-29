package com.lld.elevatorsystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Elevator {
    private String name;
    private int fromFloor;
    private int toFloor;
    private int startTime;
    private boolean isMovingUp;
    private int maxFloor;
    private boolean isCurrentlyAvailable;

    public Elevator(String name, int maxFloor) {
        this.name = name;
        this.fromFloor = 0;
        this.startTime = 0;
        this.isMovingUp = true;
        this.maxFloor = maxFloor;
        this.isCurrentlyAvailable= true;
    }

    public void move() {
        if(isMovingUp){
            fromFloor++;
        }
        else{
            fromFloor--;
        }
    }

    public void blockElevator() {
        this.isCurrentlyAvailable = false;
    }

    public void unBlockElevator(){
        this.isCurrentlyAvailable = true;
    }
}
