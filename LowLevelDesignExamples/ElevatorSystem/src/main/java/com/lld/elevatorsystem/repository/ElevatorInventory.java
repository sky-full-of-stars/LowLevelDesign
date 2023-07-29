package com.lld.elevatorsystem.repository;

import com.lld.elevatorsystem.model.Elevator;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ElevatorInventory {
    private List<Elevator> elevatorList;

    public  ElevatorInventory initializeElevators(int numOfElevators, int numOfFloors) {
        ElevatorInventory elevatorInventory = new ElevatorInventory();
        List<Elevator> elevatorList = new ArrayList<>();
        for(int i=1; i<=numOfElevators; i++)
        {
            elevatorList.add(new Elevator("Lift"+i,numOfFloors));
        }
        elevatorInventory.setElevatorList(elevatorList);
        return elevatorInventory;
    }
}
