package com.lld.uber.model;

import com.lld.uber.enums.DriverStatus;
import com.lld.uber.enums.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Driver {
    private int id;
    private String name;
    private Vehicle vehicle;
    private DriverStatus status;

    public void changeAvailability(DriverStatus toStatus) {
        this.status = toStatus;
    }

    public void collectCash(double fare) {
        System.out.print("Collected cash of " + fare);
    }

    public void endRide(Ride ride) {
        System.out.println("Ending ride...");
        ride.setRideStatus(RideStatus.COMPLETED);
        this.collectCash(ride.getFare());
        this.status = DriverStatus.ACTIVELY_LOOKING;
    }

    public void updateLocation(Location location) {
        this.vehicle.setLocation(location);
    }
}
