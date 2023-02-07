package com.lld.parkinglot.model;

import com.lld.parkinglot.exceptions.NoCarParkedWithGivenRegistrationNumberException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
public class ParkingLot {
    private int id;
    private String name;
    private final int size;
    private List<Slot> slots;

    public Slot getParkingSlotByRegNum(String regNum) {
        Optional<Slot> parkedCarSlot = getSlots().stream().filter(v -> v.getVehicle().getRegistrationNum().equals(regNum)).findFirst();
        if(parkedCarSlot.isEmpty()) {
            throw new NoCarParkedWithGivenRegistrationNumberException();
        }
        return parkedCarSlot.get();
    }
}
