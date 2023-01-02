package com.lld.uber.service;

import com.lld.uber.model.Vehicle;

public class FareService {

    public static double calculateFare(Vehicle vehicle, double distance) {
        return vehicle.getFare(distance);
    }
}
