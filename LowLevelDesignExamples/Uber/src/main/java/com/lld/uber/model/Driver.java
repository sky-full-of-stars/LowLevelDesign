package com.lld.uber.model;

import com.lld.uber.enums.DriverStatus;

public class Driver {
    private String id;
    private String name;
    private Vehicle vehicle;
    private DriverStatus status;

    public void changeAvailability(DriverStatus tostaus) {
        this.status = status;
    }

    public void collectCash(int fare) {
        System.out.print("Collected cash of " + fare);
    }

    public void endRide(Ride ride) {

    }

    public void updateLocation(Location location) {
        this.vehicle.setLocation(location);
    }
}
