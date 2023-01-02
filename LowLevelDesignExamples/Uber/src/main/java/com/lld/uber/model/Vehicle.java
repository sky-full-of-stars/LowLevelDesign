package com.lld.uber.model;

import com.lld.uber.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Vehicle {
    private String name;
    private VehicleType type;
    private int capacity;
    private String regNum;
    private Location location;

    public abstract double getFare(double distance);
}
