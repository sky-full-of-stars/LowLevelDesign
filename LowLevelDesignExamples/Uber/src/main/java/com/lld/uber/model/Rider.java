package com.lld.uber.model;

import com.lld.uber.enums.RideStatus;

public class Rider {
    private int id;
    private int name;
    private Location location;
    private Ride currentRide;

    public RideStatus getCurrentStatus() {
        return this.currentRide.getRideStatus();
    }


}
