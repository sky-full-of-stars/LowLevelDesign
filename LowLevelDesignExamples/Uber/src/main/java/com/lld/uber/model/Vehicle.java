package com.lld.uber.model;

import com.lld.uber.enums.VehicleType;
import lombok.Data;

@Data
public class Vehicle {
    private String name;
    private VehicleType type;
    private int capacity;
    private String regNum;
    private Location location;

}
