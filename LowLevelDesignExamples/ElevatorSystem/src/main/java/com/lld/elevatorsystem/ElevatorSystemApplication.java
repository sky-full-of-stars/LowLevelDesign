package com.lld.elevatorsystem;

import com.lld.elevatorsystem.enums.ElevatorAllocationWays;
import com.lld.elevatorsystem.model.PersonRequest;
import com.lld.elevatorsystem.repository.ElevatorInventory;
import com.lld.elevatorsystem.service.AllotElevatorFactory;
import com.lld.elevatorsystem.service.AllotElevatorService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ElevatorSystemApplication {

    private static Scanner scanner = new Scanner(System.in);
    private static final ElevatorAllocationWays DEFAULT_ELEVATOR_ALLOCATION_WAY = ElevatorAllocationWays.LEAST_WAIT_TIME_FIRST;

    public static void main(String[] args) {
        //SpringApplication.run(ElevatorSystemApplication.class, args);

        //Input
        int numOfFloors = scanner.nextInt();
        int numOfElevators = scanner.nextInt();
        int numOfPeople = scanner.nextInt();
        scanner.nextLine();
        List<PersonRequest> people = getInputRequestingPeople(numOfPeople);

        //Inventory
        ElevatorInventory elevatorInventory = new ElevatorInventory().initializeElevators(numOfElevators,numOfFloors);

        //Logic
        AllotElevatorFactory elevatorServiceFactory = new AllotElevatorFactory();
        AllotElevatorService elevatorService = elevatorServiceFactory.fetchElevatorAllocationService(DEFAULT_ELEVATOR_ALLOCATION_WAY);
        elevatorService.allot(people, elevatorInventory);
    }


    private static List<PersonRequest> getInputRequestingPeople(int numOfPeople) {
        List<PersonRequest> people = new ArrayList<>();
        for(int i=0; i<numOfPeople; i++){
            String[] eachPersonDetail = scanner.nextLine().split(" ");
            String personName = eachPersonDetail[0];
            int arrivingTime = Integer.parseInt(eachPersonDetail[0]);
            int fromFloor = Integer.parseInt(eachPersonDetail[1]);
            int toFloor = Integer.parseInt(eachPersonDetail[2]);
            people.add(new PersonRequest(personName, arrivingTime, fromFloor, toFloor));
        }
        return people;
    }

}
