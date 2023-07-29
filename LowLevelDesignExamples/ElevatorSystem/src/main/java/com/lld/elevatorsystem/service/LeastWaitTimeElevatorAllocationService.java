package com.lld.elevatorsystem.service;

import com.lld.elevatorsystem.model.Elevator;
import com.lld.elevatorsystem.model.OptimalElevator;
import com.lld.elevatorsystem.model.PersonRequest;
import com.lld.elevatorsystem.repository.ElevatorInventory;

import java.util.Comparator;
import java.util.List;

public class LeastWaitTimeElevatorAllocationService implements AllotElevatorService{

    @Override
    public void allot(List<PersonRequest> people, ElevatorInventory elevatorInventory) {
        people.sort(Comparator.comparingInt(PersonRequest::getArrivingTime));
        int totalTimeToServeAllPeople = 0;

        for (PersonRequest person : people) {
            OptimalElevator elevator = getOptimalElevator(person, elevatorInventory.getElevatorList());
            Elevator nearestElevator = elevator.getElevator();

            nearestElevator.setStartTime(person.getArrivingTime()+ elevator.getWaitingTime());
            nearestElevator.setToFloor(person.getToFloor());
            nearestElevator.setFromFloor(person.getFromFloor());
            nearestElevator.blockElevator();
            System.out.println("Person "+ person.getName() +" was picked up by elevator "+ nearestElevator.getName());

            int totalWaitingDurationForElevator = elevator.getWaitingTime();
            totalTimeToServeAllPeople += totalWaitingDurationForElevator;

            //nearestElevator.setMovingUp((nearestElevator.getFromFloor() < person.getToFloor()));

            //once we decide, we just move elevator
            int timeElevatorSpentServingRequest = Math.abs(nearestElevator.getFromFloor() - person.getToFloor());
            totalTimeToServeAllPeople+= timeElevatorSpentServingRequest;

            nearestElevator.unBlockElevator();
            System.out.println("Person "+ person.getName() +" was dropped to floor "+ nearestElevator.getFromFloor());
        }
        System.out.println("Total minimum time to serve all requests " + totalTimeToServeAllPeople);
    }

    @Override
    public OptimalElevator getOptimalElevator(PersonRequest person, List<Elevator> elevatorList) {
        int minDistance = Integer.MAX_VALUE;
        OptimalElevator closestElevator = new OptimalElevator();
        for(Elevator elevator: elevatorList){
            int distanceOfPersonFromElevator = getWaitingDistance(elevator, person);
            if(distanceOfPersonFromElevator < minDistance){
                minDistance = distanceOfPersonFromElevator;
                closestElevator.setElevator(elevator);
                closestElevator.setWaitingTime(minDistance);
            }
        }
        return closestElevator;
    }

    int getWaitingDistance(Elevator elevator, PersonRequest person)
    {
        int distanceOfPersonFromElevator = 0;
        if(elevator.isCurrentlyAvailable()) {
            distanceOfPersonFromElevator = Math.abs(elevator.getFromFloor()- person.getFromFloor());
        }
        else{
            int extraWaitingDurationForElevator = 0;
            if(canPersonBePickedUpOTW(person, elevator)){
                extraWaitingDurationForElevator = 0;
            }else{
                int timeAtWhichElevatorFinishesCourse = elevator.getStartTime() + elevator.getToFloor();
                int waitingTime = Math.abs(timeAtWhichElevatorFinishesCourse - person.getArrivingTime());
                extraWaitingDurationForElevator = waitingTime + Math.abs(elevator.getToFloor() - person.getFromFloor());
            }
            distanceOfPersonFromElevator = extraWaitingDurationForElevator;
        }
        return distanceOfPersonFromElevator;
    }


    //we will pick up the person if he is on right floor at right time
    //ie, we are ignoring the case where in lift going in certain direction can wait for a while for person to arrive
    //example:
    //if lift is moving and comes to 2nd floor and time 3 but person x comes to 2nd floor at time 4, lift doesnt wait for x.
    //justification:
    //lift can't be aware of future people. lift only knows present tense
    private boolean canPersonBePickedUpOTW(PersonRequest person, Elevator elevator) {
            int pickUpRequestFloor = person.getFromFloor();
            int pickUpRequestTime = person.getArrivingTime();
            if(pickUpRequestFloor >= elevator.getFromFloor() && pickUpRequestFloor<= elevator.getToFloor()) {
                int timeAtWhichFloorIsReached = elevator.getStartTime() + Math.abs(pickUpRequestFloor - elevator.getFromFloor());
                return (timeAtWhichFloorIsReached == pickUpRequestTime);
            }
           return false;
    }
}
