package com.lld.uber.model;

import com.lld.uber.enums.RideStatus;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Rider {
    private int id;
    private String name;
    private Location location;
    private Ride currentRide;

    public RideStatus getCurrentStatus() {
        return this.currentRide.getRideStatus();
    }
}
