package com.example.lld.carRentalSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
public abstract class Vehicle {
    private int kmsDriven;
    private String regNum;
    private int milage;
    private String name;
    private boolean isAvailable;
}
