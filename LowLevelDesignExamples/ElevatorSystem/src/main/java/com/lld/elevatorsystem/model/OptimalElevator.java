package com.lld.elevatorsystem.model;

import lombok.Data;

@Data
public class OptimalElevator {
    private Elevator elevator;
    private int waitingTime;
}
