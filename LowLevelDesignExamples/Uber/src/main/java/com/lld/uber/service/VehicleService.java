package com.lld.uber.service;

import com.lld.uber.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleService {
    private List<Vehicle> vehicleList = new ArrayList<>();
    public void registerVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }
}
