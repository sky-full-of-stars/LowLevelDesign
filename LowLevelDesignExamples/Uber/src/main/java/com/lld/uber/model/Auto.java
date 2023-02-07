package com.lld.uber.model;

import com.lld.uber.enums.AutoType;
import com.lld.uber.enums.VehicleType;

public class Auto extends Vehicle {
    private AutoType autoType;
    int perUnitDistanceFee;

    public Auto(String name, VehicleType type, int capacity, String regNum, Location location) {
        super(name, type, capacity, regNum, location);
    }

    @Override
    public double getFare(double distance) {
        return 0;
    }
}
