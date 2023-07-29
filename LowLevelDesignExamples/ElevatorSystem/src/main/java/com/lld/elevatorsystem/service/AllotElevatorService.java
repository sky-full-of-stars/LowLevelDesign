package com.lld.elevatorsystem.service;

import com.lld.elevatorsystem.model.Elevator;
import com.lld.elevatorsystem.model.OptimalElevator;
import com.lld.elevatorsystem.model.PersonRequest;
import com.lld.elevatorsystem.repository.ElevatorInventory;

import java.util.List;

public interface AllotElevatorService {
    void allot(List<PersonRequest> people, ElevatorInventory elevatorInventory);
    OptimalElevator getOptimalElevator(PersonRequest person, List<Elevator> elevatorList);
}
