package com.lld.uber.service;

import com.lld.uber.exception.RideNotFoundException;
import com.lld.uber.model.Driver;
import com.lld.uber.model.Location;
import com.lld.uber.model.Ride;
import com.lld.uber.model.Rider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RiderService {
//    @Autowired
//    private Environment env;

//    @Value ("${driver.distance.maximum.threshold}")
//    private String radius;

    private TripService tripService;
    private ProximityService proximityService;

    public RiderService(TripService tripService, ProximityService proximityService) {
        this.tripService = tripService;
        this.proximityService = proximityService;
    }

    private List<Rider> riderList = new ArrayList<>();

    public void registerRider(Rider rider) {
        riderList.add(rider);
    }

    public List<Ride> getAllRides(Rider rider) {
        return tripService.getRideList().
                stream().
                filter(v -> v.getRiderList().contains(rider)).collect(Collectors.toList());
    }

    public Ride requestRide(Rider rider, Location source, Location destination) throws RideNotFoundException {
        //int radius = 10;//Integer.parseInt(env.getProperty("driver.distance.maximum.threshold"));
        final List<Driver> nearByDrivers = proximityService.getDriversInRadiusOfLocation(source, 10);
        if (CollectionUtils.isEmpty(nearByDrivers)) {
            throw new RideNotFoundException();
        }
        else {
            Ride ride = tripService.createNewSoloRide(source, destination, rider, nearByDrivers);
            System.out.println("Found ride: " + ride);
            return ride;
        }
    }
}
