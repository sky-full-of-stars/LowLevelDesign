package com.lld.parkinglot.service;

import com.lld.parkinglot.enums.Color;
import com.lld.parkinglot.exceptions.NoFreeSlotAvailableException;
import com.lld.parkinglot.exceptions.ParkingLotAlreadyExists;
import com.lld.parkinglot.exceptions.SlotAlreadyOccupiedException;
import com.lld.parkinglot.model.ParkingLot;
import com.lld.parkinglot.model.Slot;
import com.lld.parkinglot.model.Vehicle;
import com.lld.parkinglot.strategy.ParkingStrategy;

import java.util.*;

public class ParkingLotService {

    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public void park(String color, String registrationNum) {
        int freeSlotNum = parkingStrategy.nextSlot();
        Slot firstSlot = parkingLot.getSlots().stream().filter(v -> v.getSlotNum() == freeSlotNum).findFirst().get();
        if(firstSlot.isFree()) {
            Vehicle vehicle = new Vehicle(null, registrationNum, Color.getColor(color));
            firstSlot.setVehicle(vehicle);
        }
        else {
            throw new SlotAlreadyOccupiedException();
        }
    }

    public void createParkingLot(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {
        if(Objects.nonNull(this.parkingLot)) {
            throw new ParkingLotAlreadyExists("attempting to create duplicate not allowed");
        }
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
    }

    public void exit() {
        System.out.println("Exiting application!");
        System.exit(1);
    }

    public void regNumByColor(Color color) {
        System.out.printf("Vehicles with color %s have reg num as: ", color.getColour());
        this.parkingLot.getSlots().stream()
                .filter(v -> v.getVehicle().getColor().equals(color))
                .map(v-> v.getVehicle().getRegistrationNum())
                .forEach(v -> System.out.printf(v + " "));
    }

    public int getSlotByRegistrationNumber(String regNum) {
        Slot parkedCarSlot = parkingLot.getParkingSlotByRegNum(regNum);
        return parkedCarSlot.getSlotNum();
    }

    public void status() {
        try {
            parkingStrategy.nextSlot();
        }
        catch (NoFreeSlotAvailableException e) {
            System.out.println("Parking lot is full!");
            return;
        }
        System.out.println("There are available parking space for vehicles");
    }

    public void unPark(String regNum) {
        Slot parkedCarSlot = parkingLot.getParkingSlotByRegNum(regNum);
        parkedCarSlot.setFree(true);
        parkedCarSlot.setVehicle(null);
        parkingStrategy.removeSlot(parkedCarSlot.getSlotNum());
    }
}
