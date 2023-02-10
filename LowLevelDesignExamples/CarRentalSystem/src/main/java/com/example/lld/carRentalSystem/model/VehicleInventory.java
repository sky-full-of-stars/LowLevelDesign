package com.example.lld.carRentalSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class VehicleInventory {
    private List<Vehicle> vehicles;
}
